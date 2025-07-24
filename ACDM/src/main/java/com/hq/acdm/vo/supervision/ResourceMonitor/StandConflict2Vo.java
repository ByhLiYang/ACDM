package com.hq.acdm.vo.supervision.ResourceMonitor;

import lombok.Data;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/11/16 16:14
 * @Description
 */
@Data
public class StandConflict2Vo {
    private List<StandConflictVo> standConflictVoList;
    private int sum;
}
