package com.hq.acdm.vo.abnormal;

import com.hq.acdm.vo.supervision.managermonitor.DateName;
import com.hq.acdm.vo.supervision.managermonitor.FourD;
import lombok.Data;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/9/27 0027
 * @Description:
 */
@Data
public class DelayLiveVO {

    /** 离港航班延误 */
    private List<FiveD> tableData1;

    /** 离港航线延误 */
    private List<FiveD> tableData2;

    /** 三大区域人数 */
    private List<DateName> tableData3;

    /** 离港延误时间分析 */
    private List<FourD> tableData4;

    /** 本小时和未来一小时起降航班数量 */
    private List<FiveD> tableData5;

    /** 总人数 */
    private String totalPersonNum;

    /** 已执行 */
    private Integer executed;

    /** 未执行 */
    private Integer nonExecution;

    /** 取消 */
    private Integer cancel;

    /** 正常率 */
    private String normalRate;

    /** 放行率 */
    private String passRate;

    /** 最近进港航班 */
    private String recentInbound;

    /** 进港时间 */
    private String inboundTime;

    /** 最近离港航班 */
    private String recentOutbound;

    /** 离港时间 */
    private String outboundTime;

}
