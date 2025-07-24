package com.hq.acdm.service.dynamicFlight;

import com.hq.acdm.vo.dynamicFlight.FlightInfoVo;
import com.hq.acdm.vo.dynamicFlight.PresetFieldCXVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface BoardingCameraService {

    //根据登录口查询摄像机ID号
    List<String> findDeviceNameInfo(@Param("params") Map params);

}
