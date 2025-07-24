package com.hq.acdm.service.Vedio;

import com.hq.acdm.model.Video.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 16:54
 */
public interface VideoService {
    Map<String, Object> queryByCondition(Map<String,Object> map);
    Map<String, Object> queryHistory(Map<String,Object> map);
    Map<String, Object> queryByStand(Map<String,Object> map);
    Map<String,Object> queryVideoHistoiy(Map<String,Object> map);
}
