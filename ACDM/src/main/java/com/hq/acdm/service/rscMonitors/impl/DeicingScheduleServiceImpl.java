package com.hq.acdm.service.rscMonitors.impl;

import com.hq.acdm.dao.rscMonitors.TEarlyDeicingMapper;
import com.hq.acdm.model.rscMonitors.TEarlyDeicing;
import com.hq.acdm.service.rscMonitors.DeicingScheduleService;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.vo.rscMonitors.EarlyDeicingVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2020/12/17 11:08
 * @Description
 */
@Service
public class DeicingScheduleServiceImpl implements DeicingScheduleService {
    @Resource
    private TEarlyDeicingMapper tEarlyDeicingMapper;
    @Override
    public List<TEarlyDeicing> selectByDate(String execDate, String type) {
        //返回结果集合
        List<TEarlyDeicing> rsList = new ArrayList<>();
        //查询除冰计划表
        List<TEarlyDeicing> list = tEarlyDeicingMapper.selectByDate(execDate);
        //除冰计划表中没有数据，或者有数据但天气类型与查询条件不一致时，重算除冰计划
        if (null == list || list.size() == 0||!type.equals(list.get(0).getType())) {
            List<TEarlyDeicing> earlyFltList = null;
            if (null!=list&&list.size()>0){
                earlyFltList = list;
                for (int i = 0; i < list.size(); i++) {
                    tEarlyDeicingMapper.deleteByPrimaryKey(list.get(i).getId());
                }
            }else{
                //查询早出港航班
                earlyFltList = tEarlyDeicingMapper.selectEarlyFltByDate(execDate);
            }
            //计算预计除冰时间等并入库
            int deicing = 15;
            if ("中雪".equals(type)) {
                deicing = 20;
            } else if ("大雪".equals(type)) {
                deicing = 30;
            }
            //按天气类型计算预计除冰时间
            for (int i = 0; i < earlyFltList.size(); i++) {
                //预计开始除冰时间=SOBT-除冰时间-滑行时间
                earlyFltList.get(i).setEcdt(DateTimeUtil.subMin(earlyFltList.get(i).getSobt(),deicing+15));
                //最晚开始除冰时间=预计开始除冰时间+（放行临界-SOBT）
                earlyFltList.get(i).setLcdt(DateTimeUtil.subMin(earlyFltList.get(i).getSobt(),deicing-10));
                //最晚关门时间=最晚除冰-10min
                earlyFltList.get(i).setLtdc(DateTimeUtil.subMin(earlyFltList.get(i).getSobt(),deicing-20));
            }
            //对除冰计划进行排序
            rsList = sortEarlyDeicing(earlyFltList);
            for (int i = 0; i < rsList.size(); i++) {
                rsList.get(i).setExecDate(execDate);
                rsList.get(i).setType(type);
                tEarlyDeicingMapper.insert(rsList.get(i));
            }
        }else {
            rsList = list;
        }
        //预计除冰时间大于最晚除冰时间时，预警显示红色
        for (int i = 0; i < rsList.size(); i++) {
            if (DateTimeUtil.compareStr(rsList.get(i).getLcdt(),rsList.get(i).getEcdt())){
                rsList.get(i).setRemark("1");
            }
        }
        return rsList;
    }

    @Override
    public int updateByFlno(TEarlyDeicing record) {
        //排序好后的集合
        List<TEarlyDeicing> rsList = new ArrayList<>();
        //查询除冰计划
        List<TEarlyDeicing> list = tEarlyDeicingMapper.selectByDate(record.getExecDate());
        //删除需修改之前的航班，剩下的航班重新排序
        for (int i = 0; i < list.size(); i++) {
            if (record.getFlno().equals(list.get(i).getFlno())&&record.getExecDate().equals(list.get(i).getExecDate())){
                list.get(i).setArea(record.getArea());
                list.get(i).setEcdt(record.getEcdt());
                list.get(i).setManual("1");
                break;
            }
            list.remove(i);
            i--;
        }
        rsList = sortEarlyDeicing(list);
        int result = 0;
        for (int i = 0; i < rsList.size(); i++) {
            result = result + tEarlyDeicingMapper.updateByPrimaryKey(rsList.get(i));
        }
        return result;
    }

    @Override
    public int updateStand(TEarlyDeicing record) {
        return tEarlyDeicingMapper.updateStand(record);
    }

    @Override
    public List<String> selectStand(TEarlyDeicing record) {
        return tEarlyDeicingMapper.selectStand(record);
    }

    @Override
    public List<EarlyDeicingVo> selectFltLocation(String execDate) {
        return tEarlyDeicingMapper.selectFltLocation(execDate);
    }

    public List<TEarlyDeicing> sortEarlyDeicing(List<TEarlyDeicing> earlyFltList) {
        List<TEarlyDeicing> rsList = new ArrayList<>();
        //分4个区域排序
        List<TEarlyDeicing> w1 = new ArrayList<>();
        List<TEarlyDeicing> w2 = new ArrayList<>();
        List<TEarlyDeicing> e1 = new ArrayList<>();
        List<TEarlyDeicing> e2 = new ArrayList<>();
        for (int i = 0; i < earlyFltList.size(); i++) {
        //若手动修改过区域或预计除冰时间，不重新分配区域和时间
            if (null!=earlyFltList.get(i).getManual()&&"1".equals(earlyFltList.get(i).getManual())){
                if ("西二".equals(earlyFltList.get(i).getArea())){
                    w2.add(earlyFltList.get(i));
                }else if ("西一".equals(earlyFltList.get(i).getArea())){
                    w1.add(earlyFltList.get(i));
                }else if ("东二".equals(earlyFltList.get(i).getArea())){
                    e2.add(earlyFltList.get(i));
                }else if ("东一".equals(earlyFltList.get(i).getArea())){
                    e1.add(earlyFltList.get(i));
                }
            }else{
                //东航代理航班先西二，再西一
                if (earlyFltList.get(i).getFlno().contains("MU") || earlyFltList.get(i).getFlno().contains("FM")) {
                    earlyFltList.get(i).setArea("西二");
                    w2.add(earlyFltList.get(i));
                //地服代理航班西一
                } else if (earlyFltList.get(i).getFlno().contains("DZ")) {
                    earlyFltList.get(i).setArea("西一");
                    w1.add(earlyFltList.get(i));
                //南航代理航班先东二，再东一
                } else if (earlyFltList.get(i).getFlno().contains("CZ") || earlyFltList.get(i).getFlno().contains("OQ")) {
                    earlyFltList.get(i).setArea("东二");
                    e2.add(earlyFltList.get(i));
                //国航代理航班先东一
                } else if (earlyFltList.get(i).getFlno().contains("CA") || earlyFltList.get(i).getFlno().contains("ZH")) {
                    earlyFltList.get(i).setArea("东一");
                    e1.add(earlyFltList.get(i));
                }
            }
        }
        //西二队列排序
        for (int i = 1; i < w2.size() && w2.size()>1; i++) {
            //同队列间隔大于等于15分钟
            if (DateTimeUtil.subMinDateTime(w2.get(i).getEcdt(),w2.get(i-1).getEcdt())<15){
                String ecdt = DateTimeUtil.subMin(w2.get(i-1).getEcdt(),-15);
                //最晚除冰小于预计除冰时，放入西一队列
                if (DateTimeUtil.compareStr(w2.get(i).getLcdt(),ecdt)){
                    for (int j = 0; j < w1.size(); j++) {
                        if (DateTimeUtil.compareStr(w1.get(j).getEcdt(),w2.get(i).getEcdt())){
                            if (j==w1.size()-1||DateTimeUtil.compareStr(w2.get(i).getEcdt(),w1.get(j+1).getEcdt())){
                                w2.get(i).setArea("西一");
                                w1.add(j+1,w2.get(i));
                                w2.remove(i);
                                i=i-1;
                            }
                        }
                    }
                }else{
                    w2.get(i).setEcdt(ecdt);
                }
            }
        }
        //西一队列排序
        for (int i = 1; i < w1.size() && w1.size()>1; i++) {
            if (DateTimeUtil.subMinDateTime(w1.get(i).getEcdt(),w1.get(i-1).getEcdt())<15){
                w1.get(i).setEcdt(DateTimeUtil.subMin(w1.get(i-1).getEcdt(),-15));
            }
        }
        //东二队列排序
        for (int i = 1; i < e2.size() && e2.size()>1; i++) {
            //同队列间隔大于等于15分钟
            if (DateTimeUtil.subMinDateTime(e2.get(i).getEcdt(),e2.get(i-1).getEcdt())<15){
                String ecdt = DateTimeUtil.subMin(e2.get(i-1).getEcdt(),-15);
                //最晚除冰小于预计除冰时，放入东一队列
                if (DateTimeUtil.compareStr(e2.get(i).getLcdt(),ecdt)){
                    for (int j = 0; j < e1.size(); j++) {
                        if (DateTimeUtil.compareStr(e1.get(j).getEcdt(),e2.get(i).getEcdt())){
                            if (j==e1.size()-1||DateTimeUtil.compareStr(e2.get(i).getEcdt(),e1.get(j+1).getEcdt())){
                                e2.get(i).setArea("东一");
                                e1.add(j+1,e2.get(i));
                                e2.remove(i);
                                i=i-1;
                            }
                        }
                    }
                }else{
                    e2.get(i).setEcdt(ecdt);
                }
            }
        }
        //东一队列排序
        for (int i = 1; i < e1.size() && e1.size()>1; i++) {
            if (DateTimeUtil.subMinDateTime(e1.get(i).getEcdt(),e1.get(i-1).getEcdt())<15){
                e1.get(i).setEcdt(DateTimeUtil.subMin(e1.get(i-1).getEcdt(),-15));
            }
        }
        rsList.addAll(w1);
        rsList.addAll(w2);
        rsList.addAll(e1);
        rsList.addAll(e2);
        return rsList;
    }
}
