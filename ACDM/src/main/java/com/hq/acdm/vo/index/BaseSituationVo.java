package com.hq.acdm.vo.index;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author lizhifeng
 * @Date 2018/9/4 0004
 * @Description:
 */
@Data
public class BaseSituationVo {

    @ApiModelProperty("总航班数")
    private int FlightNum;

    @ApiModelProperty("国际")
    private int international;

    @ApiModelProperty("国内")
    private int domestic;

    @ApiModelProperty("已执行")
    private int executed;

    @ApiModelProperty("未执行")
    private int nonExecution;

    @ApiModelProperty("正常率")
    private String normalRate;

    @ApiModelProperty("放行率")
    private String passRate;

    @ApiModelProperty("机上人数")
    private int flightPersonNum;

    @ApiModelProperty("候机区人数")
    private int waitFlightPersonNum;

    @ApiModelProperty("安检区人数")
    private int securityPersonNum;

    @ApiModelProperty("总人数")
    private String totalPersonNum;

    @ApiModelProperty("昨日计划")
    private int yesterdayPlan;

    @ApiModelProperty("昨日实际")
    private int yesterdayActual;

    @ApiModelProperty("昨日正常率")
    private String yesterdayNormalRate;

    @ApiModelProperty("昨日放行率")
    private String yesterdayPassRate;

    @ApiModelProperty("延误")
    private int delay;

    @ApiModelProperty("取消")
    private int cancel;

    @ApiModelProperty("备降")
    private int preparationForDrop;

}
