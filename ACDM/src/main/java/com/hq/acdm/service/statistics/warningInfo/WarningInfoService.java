package com.hq.acdm.service.statistics.warningInfo;

import com.hq.acdm.model.statistics.warningInfo.*;
import org.apache.ibatis.annotations.Param;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/29 0029 15:15
 */
public interface WarningInfoService {
    int INSERT_OPERATION_LOG(@Param("params")Map<String,Object> map);
    Map<String,Object> queryWarningInfo() throws ParseException;
}
