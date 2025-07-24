package com.hq.acdm.service.dynamicFlight;

import com.hq.acdm.model.realtimeSituation.TMultiDatasourceRecord;
import com.hq.acdm.vo.dynamicFlight.*;
import com.hq.acdm.vo.sysManager.HotelInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface AirFoodService {

    //获取所有航班列表
    public List<AirFoodFlightInfoVo> findAirFoodFltInfo(@Param("params") Map params);
    public List<AirPlanFoodVo> findImportAirPlanFood(InputStream in);

    int updateByPrimaryKeySelective(AirPlanFoodVo record);

    int insert(AirPlanFoodVo record);
    int deleteByPrimaryKey(@Param("quarter") String quarter,@Param("username") String username);
    int addTaxiTimeVarBatch(@Param("emps") List<AirPlanFoodVo> emps);
}
