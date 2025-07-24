package com.hq.acdm.param.sys;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author: lizhifeng
 * @Date: 2018/8/18
 * @Description:
 */
@Getter
@Setter
public class UserParam {
    @ApiModelProperty("用户id,新增时为空")
    private Integer id;

    @ApiModelProperty("登录名")
    @NotBlank(message = "登录名不可以为空")
    @Length(min = 1, max = 20, message = "登录名长度需要在20个字以内")
    private String nickName;

    @ApiModelProperty("电话号码， 可以为空")
    @Length(max = 13, message = "电话长度需要在13个字以内")
    private String phone;

    @ApiModelProperty("邮箱， 可以为空")
    @Length(max = 50, message = "邮箱长度需要在50个字符以内")
    private String email;

    @ApiModelProperty("用户的状态 1：激活，0：冻结状态")
    @NotNull(message = "必须指定用户的状态")
    @Min(value = 0, message = "用户状态不合法")
    @Max(value = 2, message = "用户状态不合法")
    private Integer status;

    @ApiModelProperty("备注")
    @Length(max = 200, message = "备注长度需要在200个字以内")
    private String remarks = "";

}
