package com.hq.acdm.dao.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.AloneVo;
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
public interface AloneMapper {
    List<AloneVo> findAloneFlights(@Param("params") Map params);

}
