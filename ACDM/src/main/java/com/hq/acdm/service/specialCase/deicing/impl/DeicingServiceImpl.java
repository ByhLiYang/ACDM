package com.hq.acdm.service.specialCase.deicing.impl;

import com.hq.acdm.dao.specialCase.DeicingMapper;
import com.hq.acdm.model.specialCase.deicing.deicingModel;
import com.hq.acdm.model.specialCase.deicing.stand;
import com.hq.acdm.service.specialCase.deicing.DeicingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/10/31 0031 11:03
 */
@Service("DeicingService")
public class DeicingServiceImpl implements DeicingService{
    @Resource
    private DeicingMapper deicingMapper;


    @Override
    public List<deicingModel> selectByPk(Map params) {
        return deicingMapper.selectByPk(params);
    }

    @Override
    public List<stand> queryStand() {
        return deicingMapper.queryStand();
    }


    @Override
    public int update(String deicingORnot, String deicingType, String deicingPart, String deicingStart, String deicingEnd, String a_or_d, String FLIGHT_REPEAT_COUNT, String operational_date, String FLIGHT_NO_IATA) throws ParseException {
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        int temp = 0;
        int tempType = 0;
        int tempStand = 0;
        if("是".equals(deicingORnot)){
            temp = 1;
        }else if("否".equals(deicingORnot)){
            temp = 0;
        }else if("全部".equals(deicingORnot)){
            temp = 2;
        }
        if("全部".equals(deicingType)){
            tempType = 2;
        }else if("定点除冰".equals(deicingType)){
            tempType = 1;
        }else if("集中除冰".equals(deicingType)){
            tempType = 0;
        }
        if("南区".equals(deicingPart)){
            tempStand = 0;
        }else if("北区".equals(deicingPart)){
            tempStand = 1;
        }else{
            tempStand = Integer.parseInt(deicingPart);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String temp_start = deicingStart.toString().substring(0,10)+" "+deicingStart.toString().substring(11,19);
        String temp_end = deicingEnd.toString().substring(0,10)+" "+deicingEnd.toString().substring(11,19);
        Date sdate = sdf.parse(temp_start);
        Date edate = sdf.parse(temp_end);
        map1.put("deicingORnot",temp);
        map1.put("deicingType",tempType);
        map1.put("deicingPart",tempStand);
        map1.put("a_or_d",a_or_d);
        map1.put("FLIGHT_REPEAT_COUNT",FLIGHT_REPEAT_COUNT);
        map1.put("operational_date",operational_date.substring(0,10));
        map1.put("flightNum",FLIGHT_NO_IATA);
        map2.put("deicingStart", sdate);
        map2.put("deicingEnd",edate);
        map2.put("a_or_d",a_or_d);
        map2.put("FLIGHT_REPEAT_COUNT",FLIGHT_REPEAT_COUNT);
        map2.put("operational_date",operational_date.substring(0,10));
        map2.put("flightNum",FLIGHT_NO_IATA);
        int result1 = deicingMapper.updateDAILY_FLIGHT_ADD_DETAILS(map1);
        int result2 = deicingMapper.updateDAILY_FLIGHT_MASTER(map2);


        return result1+result2;
    }
}
