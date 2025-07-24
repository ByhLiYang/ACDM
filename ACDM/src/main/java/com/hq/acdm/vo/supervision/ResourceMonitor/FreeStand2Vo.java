package com.hq.acdm.vo.supervision.ResourceMonitor;

import lombok.Data;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/11/16 16:12
 * @Description
 */
@Data
public class FreeStand2Vo {
    private List<FreeStandVo> freeStandVoList;
    private int sum;
}
