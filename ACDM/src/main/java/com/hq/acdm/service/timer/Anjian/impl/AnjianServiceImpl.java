package com.hq.acdm.service.timer.Anjian.impl;

import com.hq.acdm.dao.timer.Anjian.AnjianMapper;
import com.hq.acdm.mysql.AreaPeopleNumber;
import com.hq.acdm.service.timer.Anjian.AnjianService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 16:26
 */
@Service("AnjianService")
public class AnjianServiceImpl implements AnjianService {
    @Resource
    private AnjianMapper anjianService;
    @Override
    public Map<String,String> queryPax_num() {
        Map<String,String> map = new HashMap<>();
        List<AreaPeopleNumber> list =  anjianService.queryPax_num();
        for(int i=0;i<list.size();i++){
            if("A区".equals(list.get(i).getAREA())){
                map.put("A",String.valueOf(list.get(i).getPEOPLECOUNT()));
            }else if("B区".equals(list.get(i).getAREA())){
                map.put("B",String.valueOf(list.get(i).getPEOPLECOUNT()));
            }else if("C区".equals(list.get(i).getAREA())){
                map.put("C",String.valueOf(list.get(i).getPEOPLECOUNT()));
            }else if("D区".equals(list.get(i).getAREA())){
                map.put("D",String.valueOf(list.get(i).getPEOPLECOUNT()));
            }
        }
        return map;
    }

    @Override
    public List<AreaPeopleNumber> queryHistoricalPax_num() {
        return anjianService.queryHistoricalPax_num();
    }

    @Override
    public int insertHistoricalPax_num(Map<String, Object> map) {
        return anjianService.insertHistoricalPax_num(map);
    }

    @Override
    public int deleteHistoricalPax_num(Map<String, Object> map) {
        return anjianService.deleteHistoricalPax_num(map);
    }

    @Override
    public List<AreaPeopleNumber> queryByCondition(Map<String, Object> map) {
        return anjianService.queryByCondition(map);
    }

    @Override
    public int deleteDuplicateDate(Map<String, Object> map) {
        return anjianService.deleteDuplicateDate(map);
    }
}
