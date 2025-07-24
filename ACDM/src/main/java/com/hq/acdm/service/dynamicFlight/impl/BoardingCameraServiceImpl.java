package com.hq.acdm.service.dynamicFlight.impl;

import com.hq.acdm.dao.dynamicFlight.BoardingCameraMapper;
import com.hq.acdm.service.dynamicFlight.BoardingCameraService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class BoardingCameraServiceImpl implements BoardingCameraService {

    @Resource
    private BoardingCameraMapper boardingCameraMapper;

    @Override
    public List<String> findDeviceNameInfo(@Param("params") Map params) {
        return boardingCameraMapper.findDeviceNameInfo(params);
    }



}
