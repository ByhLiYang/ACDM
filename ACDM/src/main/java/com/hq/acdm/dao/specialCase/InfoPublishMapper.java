package com.hq.acdm.dao.specialCase;

import com.hq.acdm.model.specialCase.infoPublish.infoPublish;
import com.hq.acdm.model.specialCase.infoPublish.infoPublishResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/23 0023 13:40
 */
public interface InfoPublishMapper {
    List<infoPublishResult> queryInfoPublish(@Param("params")Map<String,Object> map);
    int addInfoPublish(infoPublish infoPublish);
}
