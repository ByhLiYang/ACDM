package com.hq.acdm.service.effectAnalysis.impl;



import com.hq.acdm.dao.effectAnalysis.AbnormalMapper;
import com.hq.acdm.dao.realtimeSituation.TFlightSupportRecordMapper;
import com.hq.acdm.model.realtimeSituation.TFlightSupportRecord;
import com.hq.acdm.service.effectAnalysis.AbnormalService;

import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.vo.dynamicFlight.TEnvelopeMsgVo;
import com.hq.acdm.vo.dynamicFlight.TLocalFlightInfoVo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class AbnormalServiceImpl implements AbnormalService {

    @Resource
    private AbnormalMapper abnormalMapper;
    @Resource
    private TFlightSupportRecordMapper tFlightSupportRecordMapper;


    @Override
    public List<TLocalFlightInfoVo> findAbnormal(@Param("params") Map params,boolean flag){
        List<TLocalFlightInfoVo> list = new ArrayList<TLocalFlightInfoVo>();
        List<TLocalFlightInfoVo> listFltInfo = abnormalMapper.getAbnormal(params);
        if(listFltInfo != null && listFltInfo.size()>0){
            for(int i=0;i<listFltInfo.size();i++){
                TLocalFlightInfoVo vo = listFltInfo.get(i);
                if (flag){

                vo.setSobt(DateTimeUtil.timeDayFormatByStr(vo.getSobt()));
                vo.setSibt(DateTimeUtil.timeDayFormatByStr(vo.getSibt()));
                vo.setCobt(DateTimeUtil.timeDayFormatByStr(vo.getCobt()));
                vo.setCtot(DateTimeUtil.timeDayFormatByStr(vo.getCtot()));
                vo.setTobt(DateTimeUtil.timeDayFormatByStr(vo.getTobt()));
                vo.setEibt(DateTimeUtil.timeDayFormatByStr(vo.getEibt()));
                vo.setAibt(DateTimeUtil.timeDayFormatByStr(vo.getAibt()));
                vo.setEobt(DateTimeUtil.timeDayFormatByStr(vo.getEobt()));
                vo.setAobt(DateTimeUtil.timeDayFormatByStr(vo.getAobt()));
                vo.setEtdo(DateTimeUtil.timeDayFormatByStr(vo.getEtdo()));
                vo.setEtdc(DateTimeUtil.timeDayFormatByStr(vo.getEtdc()));
                vo.setAtdo(DateTimeUtil.timeDayFormatByStr(vo.getAtdo()));
                vo.setAtdc(DateTimeUtil.timeDayFormatByStr(vo.getAtdc()));
                vo.setEtfo(DateTimeUtil.timeDayFormatByStr(vo.getEtfo()));
                vo.setEtfc(DateTimeUtil.timeDayFormatByStr(vo.getEtfc()));
                vo.setAtfo(DateTimeUtil.timeDayFormatByStr(vo.getAtfo()));
                vo.setAtfc(DateTimeUtil.timeDayFormatByStr(vo.getAtfc()));
                vo.setEsct(DateTimeUtil.timeDayFormatByStr(vo.getEsct()));
                vo.setEfct(DateTimeUtil.timeDayFormatByStr(vo.getEfct()));
                vo.setAsct(DateTimeUtil.timeDayFormatByStr(vo.getAsct()));
                vo.setAfct(DateTimeUtil.timeDayFormatByStr(vo.getAfct()));
                vo.setEsc(DateTimeUtil.timeDayFormatByStr(vo.getEsc()));
                vo.setEec(DateTimeUtil.timeDayFormatByStr(vo.getEec()));
                vo.setAsc(DateTimeUtil.timeDayFormatByStr(vo.getAsc()));
                vo.setAec(DateTimeUtil.timeDayFormatByStr(vo.getAec()));
                vo.setEsr(DateTimeUtil.timeDayFormatByStr(vo.getEsr()));
                vo.setEer(DateTimeUtil.timeDayFormatByStr(vo.getEer()));
                vo.setAsr(DateTimeUtil.timeDayFormatByStr(vo.getAsr()));
                vo.setAer(DateTimeUtil.timeDayFormatByStr(vo.getAer()));
                vo.setEsbt(DateTimeUtil.timeDayFormatByStr(vo.getEsbt()));
                vo.setEebt(DateTimeUtil.timeDayFormatByStr(vo.getEebt()));
                vo.setAsbt(DateTimeUtil.timeDayFormatByStr(vo.getAsbt()));
                vo.setAebt(DateTimeUtil.timeDayFormatByStr(vo.getAebt()));
                vo.setErsl(DateTimeUtil.timeDayFormatByStr(vo.getErsl()));
                vo.setElsw(DateTimeUtil.timeDayFormatByStr(vo.getElsw()));
                vo.setArsl(DateTimeUtil.timeDayFormatByStr(vo.getArsl()));
                vo.setAlsw(DateTimeUtil.timeDayFormatByStr(vo.getAlsw()));
                vo.setATobt(DateTimeUtil.timeDayFormatByStr(vo.getATobt()));
                vo.setAGrndTsfTm(DateTimeUtil.timeDayFormatByStr(vo.getAGrndTsfTm()));
                vo.setDGrndTsfTm(DateTimeUtil.timeDayFormatByStr(vo.getDGrndTsfTm()));

                }
                list.add(vo);
            }
            return list;
        }else{
            return listFltInfo;
        }
    }
    @Override
    public List<TLocalFlightInfoVo> findAbnormalHis(@Param("params") Map params){
        List<TLocalFlightInfoVo> list = new ArrayList<TLocalFlightInfoVo>();
        List<TLocalFlightInfoVo> listFltInfo = abnormalMapper.getAbnormalHis(params);
        if(listFltInfo != null && listFltInfo.size()>0){
            for(int i=0;i<listFltInfo.size();i++){
                TLocalFlightInfoVo vo = listFltInfo.get(i);
                vo.setSobt(DateTimeUtil.timeDayFormatByStr(vo.getSobt()));
                vo.setSibt(DateTimeUtil.timeDayFormatByStr(vo.getSibt()));
                vo.setCobt(DateTimeUtil.timeDayFormatByStr(vo.getCobt()));
                vo.setCtot(DateTimeUtil.timeDayFormatByStr(vo.getCtot()));
                vo.setTobt(DateTimeUtil.timeDayFormatByStr(vo.getTobt()));
                vo.setEibt(DateTimeUtil.timeDayFormatByStr(vo.getEibt()));
                vo.setAibt(DateTimeUtil.timeDayFormatByStr(vo.getAibt()));
                vo.setEobt(DateTimeUtil.timeDayFormatByStr(vo.getEobt()));
                vo.setAobt(DateTimeUtil.timeDayFormatByStr(vo.getAobt()));
                vo.setEtdo(DateTimeUtil.timeDayFormatByStr(vo.getEtdo()));
                vo.setEtdc(DateTimeUtil.timeDayFormatByStr(vo.getEtdc()));
                vo.setAtdo(DateTimeUtil.timeDayFormatByStr(vo.getAtdo()));
                vo.setAtdc(DateTimeUtil.timeDayFormatByStr(vo.getAtdc()));
                vo.setEtfo(DateTimeUtil.timeDayFormatByStr(vo.getEtfo()));
                vo.setEtfc(DateTimeUtil.timeDayFormatByStr(vo.getEtfc()));
                vo.setAtfo(DateTimeUtil.timeDayFormatByStr(vo.getAtfo()));
                vo.setAtfc(DateTimeUtil.timeDayFormatByStr(vo.getAtfc()));
                vo.setEsct(DateTimeUtil.timeDayFormatByStr(vo.getEsct()));
                vo.setEfct(DateTimeUtil.timeDayFormatByStr(vo.getEfct()));
                vo.setAsct(DateTimeUtil.timeDayFormatByStr(vo.getAsct()));
                vo.setAfct(DateTimeUtil.timeDayFormatByStr(vo.getAfct()));
                vo.setEsc(DateTimeUtil.timeDayFormatByStr(vo.getEsc()));
                vo.setEec(DateTimeUtil.timeDayFormatByStr(vo.getEec()));
                vo.setAsc(DateTimeUtil.timeDayFormatByStr(vo.getAsc()));
                vo.setAec(DateTimeUtil.timeDayFormatByStr(vo.getAec()));
                vo.setEsr(DateTimeUtil.timeDayFormatByStr(vo.getEsr()));
                vo.setEer(DateTimeUtil.timeDayFormatByStr(vo.getEer()));
                vo.setAsr(DateTimeUtil.timeDayFormatByStr(vo.getAsr()));
                vo.setAer(DateTimeUtil.timeDayFormatByStr(vo.getAer()));
                vo.setEsbt(DateTimeUtil.timeDayFormatByStr(vo.getEsbt()));
                vo.setEebt(DateTimeUtil.timeDayFormatByStr(vo.getEebt()));
                vo.setAsbt(DateTimeUtil.timeDayFormatByStr(vo.getAsbt()));
                vo.setAebt(DateTimeUtil.timeDayFormatByStr(vo.getAebt()));
                vo.setErsl(DateTimeUtil.timeDayFormatByStr(vo.getErsl()));
                vo.setElsw(DateTimeUtil.timeDayFormatByStr(vo.getElsw()));
                vo.setArsl(DateTimeUtil.timeDayFormatByStr(vo.getArsl()));
                vo.setAlsw(DateTimeUtil.timeDayFormatByStr(vo.getAlsw()));
                vo.setATobt(DateTimeUtil.timeDayFormatByStr(vo.getATobt()));
                vo.setAGrndTsfTm(DateTimeUtil.timeDayFormatByStr(vo.getAGrndTsfTm()));
                vo.setDGrndTsfTm(DateTimeUtil.timeDayFormatByStr(vo.getDGrndTsfTm()));
                list.add(vo);
            }
            return list;
        }else{
            return listFltInfo;
        }
    }

    @Override
    public int insertTFlightSupportRecord(TFlightSupportRecord record) {
        return tFlightSupportRecordMapper.insert(record);
    }

    @Override
    public int updateTFlightSupportRecord(TFlightSupportRecord record) {
        return tFlightSupportRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TFlightSupportRecord> findTFlightSupportRecord(Map params) {
        return tFlightSupportRecordMapper.selectByFlightId(params);
    }

    @Override
    public List<TEnvelopeMsgVo> getEnvelopMsg(Map params) {
        return abnormalMapper.getEnvelopMsg(params);
    }

    @Override
    public int updateMsgUser(Map params) {
        return abnormalMapper.updateMsgUser(params);
    }


}
