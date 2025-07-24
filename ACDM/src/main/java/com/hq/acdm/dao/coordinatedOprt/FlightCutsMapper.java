package com.hq.acdm.dao.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.FlightCutsVo;
import com.hq.acdm.vo.coordinatedOprt.TFlightScheduling;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/06/12 11:28
 * @Description
 */
public interface FlightCutsMapper {
    List<FlightCutsVo> getCutFlights(@Param("params") Map params);
    List<TFlightScheduling> getFlightScheduling(@Param("params") Map params);
    int getIsReduce(@Param("flightId") String flightId);
    int insertReduce(@Param("flightId") String flightId,@Param("optFlag") String optFlag);
    int updateReduce(@Param("flightId") String flightId,@Param("optFlag") String optFlag);
    int insertReduceSOBT(@Param("flightId") String flightId,@Param("optFlag") String optFlag,@Param("nsobt") String nsobt);
    int updateReduceSOBT(@Param("flightId") String flightId,@Param("optFlag") String optFlag,@Param("nsobt") String nsobt);
    int updateVrfFlightRmk(@Param("id") String id,@Param("rmk") String rmk);
}
