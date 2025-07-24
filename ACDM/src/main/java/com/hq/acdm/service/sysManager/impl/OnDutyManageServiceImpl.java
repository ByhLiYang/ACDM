package com.hq.acdm.service.sysManager.impl;

import com.hq.acdm.dao.realtimeSituation.TOndutyInfoMapper;
import com.hq.acdm.dao.realtimeSituation.TOndutyOrgMapper;
import com.hq.acdm.dao.realtimeSituation.TOndutyOrgRootMapper;
import com.hq.acdm.dao.sysManager.OnDutyManageMapper;
import com.hq.acdm.model.realtimeSituation.TOndutyInfo;
import com.hq.acdm.model.realtimeSituation.TOndutyOrg;
import com.hq.acdm.model.realtimeSituation.TOndutyOrgRoot;
import com.hq.acdm.service.sysManager.OnDutyManageService;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.vo.sysManager.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class OnDutyManageServiceImpl implements OnDutyManageService {

    @Resource
    private OnDutyManageMapper onDutyManageMapper;

    @Resource
    private TOndutyOrgRootMapper tOndutyOrgRootMapper;
    @Resource
    private TOndutyOrgMapper tOndutyOrgMapper;
    @Resource
    private TOndutyInfoMapper tOndutyInfoMapper;

    //查询值班机构信息
    @Override
    public List<OnDutyOrgVo> findOnDutyOrgInfo(@Param("params") Map params){
       return onDutyManageMapper.findOnDutyOrgInfo(params);
    }

    //查询值班机构根节点信息
    @Override
    public List<OnDutyOrgVo> findOnDutyOrgRootInfo(@Param("params") Map params){
        return onDutyManageMapper.findOnDutyOrgRootInfo(params);
    }

    //所有值班机构信息
    public List<OnDutyOrgInfoVo> findOnDutyOrgAllInfo(@Param("params") Map params){
        List<OnDutyOrgInfoVo> list = new ArrayList<OnDutyOrgInfoVo>();
        List<OnDutyOrgVo> rootList = this.findOnDutyOrgRootInfo(params);
        Map<String,Object> queryMap = new HashMap<String,Object>();
        for(int i=0;i<rootList.size();i++){
            OnDutyOrgVo rootVo = rootList.get(i);
            OnDutyOrgInfoVo odoiVo = new OnDutyOrgInfoVo();
            odoiVo.setId(rootVo.getId());
            odoiVo.setOrgType(rootVo.getOrgType());
            odoiVo.setLabel(rootVo.getLabel());
            queryMap.clear();
            queryMap.put("id",rootVo.getId());
            odoiVo.setChildren(this.findOnDutyOrgInfo(queryMap));
            list.add(odoiVo);
        }
        return list;
    }

    //根据机构ID查询所有值班信息
    public List<OnDutyDetailsVo> findOnDutyAllInfoById(@Param("params") Map params){
        return onDutyManageMapper.findOnDutyAllInfoById(params);
    }

    //所有值班信息
    public List<OnDutyInfoVo> findOnDutyAllInfo(@Param("params") Map params){
        String id = params.get("orgId").toString();
        String orgType = params.get("orgType").toString();
        String startDate = params.get("startDate").toString();
        String endDate = params.get("endDate").toString();
        List<OnDutyInfoVo> list = new ArrayList<OnDutyInfoVo>();
        String []dateArr = new String[7];
        dateArr[0] = startDate;
        try {
            dateArr[1] = DateTimeUtil.plusDay(1,startDate,"yyyy-MM-dd");
            dateArr[2] = DateTimeUtil.plusDay(2,startDate,"yyyy-MM-dd");
            dateArr[3] = DateTimeUtil.plusDay(3,startDate,"yyyy-MM-dd");
            dateArr[4] = DateTimeUtil.plusDay(4,startDate,"yyyy-MM-dd");
            dateArr[5] = DateTimeUtil.plusDay(5,startDate,"yyyy-MM-dd");
            dateArr[6] = DateTimeUtil.plusDay(6,startDate,"yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("id",id);
        if(null != orgType && "1".equals(orgType)){
            List<OnDutyOrgVo> orgList  = this.findOnDutyOrgInfo(queryMap);
            if(orgList != null && orgList.size()>0){
                for(int j=0;j<orgList.size();j++){
                    String orgId = orgList.get(j).getId();
                    String orgName = orgList.get(j).getLabel();
                    OnDutyInfoVo odiVo = new OnDutyInfoVo();
                    odiVo.setOrgId(orgId);
                    odiVo.setLabel(orgName);
                    params.remove("orgId");
                    params.put("orgId",orgId);
                    List<OnDutyDetailsVo> detailsList = this.findOnDutyAllInfoById(params);
                    if(detailsList != null && detailsList.size()>0){
                        String []empArr = new String[7];
                        String []telArr = new String[7];
                        for(int n=0;n<dateArr.length;n++){
                            String dateStr = dateArr[n];
                            for(int i=0;i<detailsList.size();i++){
                                OnDutyDetailsVo vo = detailsList.get(i);
                                if(vo.getOndutyTime().equals(dateStr)){
                                    empArr[n] = vo.getOndutyEmp();
                                    telArr[n] = vo.getTel();
                                }
                            }
                        }
                        for(int m=0;m<7;m++){
                            if(m==0){
                                odiVo.setOneN(empArr[0]);
                                odiVo.setOneT(telArr[0]);
                            }
                            if(m==1){
                                odiVo.setTwoN(empArr[1]);
                                odiVo.setTwoT(telArr[1]);
                            }
                            if(m==2){
                                odiVo.setThreeN(empArr[2]);
                                odiVo.setThreeT(telArr[2]);
                            }
                            if(m==3){
                                odiVo.setFourN(empArr[3]);
                                odiVo.setFourT(telArr[3]);
                            }
                            if(m==4){
                                odiVo.setFiveN(empArr[4]);
                                odiVo.setFiveT(telArr[4]);
                            }
                            if(m==5){
                                odiVo.setSixN(empArr[5]);
                                odiVo.setSixT(telArr[5]);
                            }
                            if(m==6){
                                odiVo.setSevenN(empArr[6]);
                                odiVo.setSevenT(telArr[6]);
                            }
                        }
                    }
                    list.add(odiVo);
                }
            }
        }

        if(null != orgType && "2".equals(orgType)){
            List<OnDutyDetailsVo> detailsList = this.findOnDutyAllInfoById(params);
            if(detailsList != null && detailsList.size()>0){
                OnDutyInfoVo odiVo = new OnDutyInfoVo();
                String []empArr = new String[7];
                String []telArr = new String[7];
                for(int n=0;n<dateArr.length;n++){
                    String dateStr = dateArr[n];
                    for(int i=0;i<detailsList.size();i++){
                        OnDutyDetailsVo vo = detailsList.get(i);
                        odiVo.setOrgId(vo.getOrgId());
                        odiVo.setLabel(vo.getOrgName());
                        if(vo.getOndutyTime().equals(dateStr)){
                            empArr[n] = vo.getOndutyEmp();
                            telArr[n] = vo.getTel();
                        }
                    }
                }
                for(int m=0;m<7;m++){
                    if(m==0){
                        odiVo.setOneN(empArr[0]);
                        odiVo.setOneT(telArr[0]);
                    }
                    if(m==1){
                        odiVo.setTwoN(empArr[1]);
                        odiVo.setTwoT(telArr[1]);
                    }
                    if(m==2){
                        odiVo.setThreeN(empArr[2]);
                        odiVo.setThreeT(telArr[2]);
                    }
                    if(m==3){
                        odiVo.setFourN(empArr[3]);
                        odiVo.setFourT(telArr[3]);
                    }
                    if(m==4){
                        odiVo.setFiveN(empArr[4]);
                        odiVo.setFiveT(telArr[4]);
                    }
                    if(m==5){
                        odiVo.setSixN(empArr[5]);
                        odiVo.setSixT(telArr[5]);
                    }
                    if(m==6){
                        odiVo.setSevenN(empArr[6]);
                        odiVo.setSevenT(telArr[6]);
                    }
                }
                list.add(odiVo);
            }
        }

        return list;
    }

    @Override
    public int insertOndutyRootOrg(TOndutyOrgRoot record) {
        return tOndutyOrgRootMapper.insert(record);
    }

    @Override
    public int insertOndutyOrg(TOndutyOrg record) {
        return tOndutyOrgMapper.insert(record);
    }

    @Override
    public int insertOndutyInfo(TOndutyInfo record) {
        return tOndutyInfoMapper.insert(record);
    }

    @Override
    public int updateOndutyRootOrg(TOndutyOrgRoot record) {
        return tOndutyOrgRootMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateOndutyOrg(TOndutyOrg record) {
        return tOndutyOrgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateOndutyInfo(TOndutyInfo record) {
        return tOndutyInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteOndutyRootOrg(String id) {
        return tOndutyOrgRootMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteOndutyOrg(String id) {
        return tOndutyOrgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteOndutyInfo(String id) {
        return tOndutyInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TOndutyOrgRoot selectOrgRootByPrimaryKey(String id) {
        return tOndutyOrgRootMapper.selectByPrimaryKey(id);
    }

    @Override
    public TOndutyOrg selectOrgByPrimaryKey(String id) {
        return tOndutyOrgMapper.selectByPrimaryKey(id);
    }

    @Override
    public TOndutyInfo selectOndutyInfoByPrimaryKey(String id) {
        return tOndutyInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public TOndutyInfo findTOndutyInfo(Map params) {
        return tOndutyInfoMapper.findTOndutyInfo(params);
    }

    public int updateByOrgIdAndOndutyDate(@Param("params") Map params){
        return tOndutyInfoMapper.updateByOrgIdAndOndutyDate(params);
    }

    @Override
    public List<OnDutyUserVo> findOnDutyUser(Map params) {
        return onDutyManageMapper.findOnDutyUser(params);
    }

}
