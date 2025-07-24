package com.hq.acdm.dao.Video;

import com.hq.acdm.model.Video.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 16:53
 */
public interface VideoMapper {
    List<Video> queryByCondition(@Param("params") Map<String,Object> map);
    List<Video> queryByStand(@Param("params") Map<String,Object> map);
}
