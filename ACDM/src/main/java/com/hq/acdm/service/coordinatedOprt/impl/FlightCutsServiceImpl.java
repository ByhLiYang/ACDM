package com.hq.acdm.service.coordinatedOprt.impl;

import com.hq.acdm.dao.coordinatedOprt.FlightCutsMapper;
import com.hq.acdm.service.coordinatedOprt.FlightCutsService;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.vo.coordinatedOprt.FlightCutsVo;
import com.hq.acdm.vo.coordinatedOprt.TFlightScheduling;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/06/12 14:23
 * @Description
 */
@Service
public class FlightCutsServiceImpl implements FlightCutsService {
    @Resource
    private FlightCutsMapper flightCutsMapper;
    @Override
    public List<FlightCutsVo> findCutFlights(Map params) {
        return flightCutsMapper.getCutFlights(params);
    }

    @Override
    public List<TFlightScheduling> findFlightScheduling(Map params) {

            return flightCutsMapper.getFlightScheduling(params);
    }

    @Override
    public int updateFlightCuts(String flightId, String optFlag) {
        if (flightCutsMapper.getIsReduce(flightId)>0){
            return flightCutsMapper.updateReduce(flightId,optFlag);
        }else{
            return flightCutsMapper.insertReduce(flightId,optFlag);
        }
    }

    @Override
    public int updateFlightCuts(String flightId, String optFlag, String nsobt) {
        if (StringUtil.isEmpty(nsobt)){
            nsobt=null;
        }
        if (flightCutsMapper.getIsReduce(flightId)>0){

            return flightCutsMapper.updateReduceSOBT(flightId,optFlag,nsobt);
        }else{
            return flightCutsMapper.insertReduceSOBT(flightId,optFlag,nsobt);
        }
    }

    @Override
    public int updateVrfFlightRmk(String id, String rmk) {
        if (StringUtil.isNotEmpty(id)){
            return flightCutsMapper.updateVrfFlightRmk(id,rmk);
        }
        return 0;
    }
}
