package com.hq.acdm.vo.supervision.postMonitor;

import lombok.Data;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/11/07 11:29
 * @Description
 */
@Data
public class PostMonitorVo {
    private List<PostMonitor> postMonitorList;
    private int sum;
}
