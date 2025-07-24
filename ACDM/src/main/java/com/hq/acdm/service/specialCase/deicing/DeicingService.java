package com.hq.acdm.service.specialCase.deicing;

import com.hq.acdm.model.specialCase.deicing.deicingModel;
import com.hq.acdm.model.specialCase.deicing.stand;
import org.apache.ibatis.annotations.Param;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/10/31 0031 11:02
 */
public interface DeicingService {
    List<deicingModel> selectByPk(Map params);
    List<stand> queryStand();
    int update(String deicingORnot,String deicingType,String deicingPart,String deicingStart,String deicingEnd,String a_or_d,String FLIGHT_REPEAT_COUNT,String operational_date,String FLIGHT_NO_IATA) throws ParseException;
}
