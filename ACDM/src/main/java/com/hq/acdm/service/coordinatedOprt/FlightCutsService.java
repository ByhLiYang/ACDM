package com.hq.acdm.service.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.FlightCutsVo;
import com.hq.acdm.vo.coordinatedOprt.TFlightScheduling;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/06/12 14:23
 * @Description
 */
public interface FlightCutsService {
    List<FlightCutsVo> findCutFlights(Map params);
    List<TFlightScheduling> findFlightScheduling(@Param("params") Map params);
    int updateFlightCuts(String flightId,String optFlag);
    int updateFlightCuts(String flightId,String optFlag,String nsobt);
    int updateVrfFlightRmk(@Param("id") String id,@Param("rmk") String rmk);
}
