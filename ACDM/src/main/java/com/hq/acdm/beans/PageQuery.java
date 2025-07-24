package com.hq.acdm.beans;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

/**
 * @Author: lizhifeng
 * @Date: 2018/8/18
 * @Description:
 */
@Getter
@Setter
public class PageQuery {

    @ApiModelProperty("当前页码")
    @Min(value = 1, message = "当前页码不合法")
    private int pageNo = 1;

    @ApiModelProperty("每页展示数量")
    @Min(value = 1, message = "每页展示数量不合法")
    private int pageSize = 10;

}
