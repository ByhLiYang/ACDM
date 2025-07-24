package com.hq.acdm.service.specialCase.infoPublish;

import com.hq.acdm.model.specialCase.infoPublish.infoPublish;
import com.hq.acdm.model.specialCase.infoPublish.infoPublishResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/23 0023 13:42
 */
public interface InfoPublishService {
    List<infoPublishResult> queryInfoPublish(Map<String,Object> map);
    int addInfoPublish(infoPublish infoPublish);
}
