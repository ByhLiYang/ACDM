package com.hq.acdm.vo.flight;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: pengzhanghua
 * @Date: 2018/9/18 15:11
 * @Description:
 */
@Data
public class VStartFlightLvVo {
    @ApiModelProperty("日期")
    private String operationalDate;

    @ApiModelProperty("航空公司")
    private String airlineCodeIata;

    @ApiModelProperty("计划航班数")
    private Integer plancount;

    @ApiModelProperty("执行航班数")
    private Integer executecount;

    @ApiModelProperty("正常")
    private Integer unnormal;

    @ApiModelProperty("不正常")
    private Integer normal;

    @ApiModelProperty("正常率")
    private String normalRate;
}
