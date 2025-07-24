package com.hq.acdm.service.coordinatedOprt.impl;

import com.hq.acdm.dao.coordinatedOprt.AloneMapper;
import com.hq.acdm.dao.coordinatedOprt.FlightCutsMapper;
import com.hq.acdm.service.coordinatedOprt.AloneService;
import com.hq.acdm.service.coordinatedOprt.FlightCutsService;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.vo.coordinatedOprt.AloneVo;
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
public class AloneServiceImpl implements AloneService {
    @Resource
    private AloneMapper aloneMapper;
    @Override
    public List<AloneVo> findAloneFlights(Map params) {
        return aloneMapper.findAloneFlights(params);
    }


}
