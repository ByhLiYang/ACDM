package com.hq.acdm.dao.dynamicFlight;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:38
 * @Description
 */
public interface BoardingCameraMapper {
    //根据登录口查询摄像机设备名称
    List<String> findDeviceNameInfo(@Param("params") Map params);


}
