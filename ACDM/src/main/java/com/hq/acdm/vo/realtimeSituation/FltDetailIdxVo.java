package com.hq.acdm.vo.realtimeSituation;

import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2019/04/01 10:22
 * @Description
 */
@Data
public class FltDetailIdxVo {
    private String attribute;
    private int plan;
    private int actual;
    private int delay;
    private int cancel;
}
