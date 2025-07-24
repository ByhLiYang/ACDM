package com.hq.acdm.model.statistics.warningInfo;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Param;

/**
 * @author wangshuhao
 * @date 2018/12/7 0007 18:46
 */
@Getter
@Setter
public class WarningInfo {
    private String DTIME;
    private String RECORDER;
    private String CURSTATUS;
}
