package com.hq.acdm.vo.supervision.managermonitor;

import lombok.Data;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/9/17 0017
 * @Description:当日跑道方向 出港延误
 */
@Data
public class OutBoundDelayVo {
    /**
     * 出港延误
     */
    private List<FourD> tableData1;
    /**
     * 当日跑道方向
     */
    private List<DateName> tableData2;
    /**
     * 出港延误总数
     */
    private String delayNum;

}
