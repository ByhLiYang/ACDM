package com.hq.acdm.param.sys.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Author lizhifeng
 * @Date 2018/8/28 0028
 * @Description:
 */
@Getter
@Setter
public class ChangePwdParam {

    @ApiModelProperty("旧密码")
    @NotBlank(message = "旧密码不可以为空")
    private String oldPwd;

    @ApiModelProperty("新密码")
    @NotBlank(message = "新密码不可以为空")
    @Length(min = 1, max = 20, message = "新密码长度需要在20个字以内")
    private String newPwd;

    @ApiModelProperty("确认密码")
    @NotBlank(message = "确认密码不可以为空")
    @Length(min = 1, max = 20, message = "确认密码长度需要在20个字以内")
    private String newPwd2;
}
