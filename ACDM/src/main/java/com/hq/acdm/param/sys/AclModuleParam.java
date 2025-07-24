package com.hq.acdm.param.sys;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Getter
@Setter
@ToString
public class AclModuleParam {

    @ApiModelProperty("菜单模块ID，新增时为空")
    private Integer id;

    @ApiModelProperty("菜单模块名称")
    @NotBlank(message = "菜单模块名称不可以为空")
    @Length(min = 2, max = 20, message = "菜单模块名称长度需要在2~20个字之间")
    private String name;

    @ApiModelProperty("菜单模块在当前层级下的顺序，由小到大")
    @NotNull(message = "菜单模块展示顺序不可以为空")
    private Integer sort;

    @ApiModelProperty("菜单模块图标")
    @NotNull(message = "菜单模块图标不可以为空")
    @Length(min = 1, max = 200, message = "菜单模块图标不可以为空,且菜单模块图标需要在200个字符长度之间")
    private String icon;

    @ApiModelProperty("菜单模块链接")
    @NotNull(message = "菜单模块链接不可以为空")
    @Length(max = 200, message = "菜单模块链接需要在200个字之间")
    private String href;

    @ApiModelProperty("菜单模块状态 1：显示，0：冻结")
    @NotNull(message = "菜单模块状态不可以为空")
    @Min(value = 0, message = "菜单模块状态不合法")
    @Max(value = 1, message = "菜单模块状态不合法")
    private Integer isShow;

    @ApiModelProperty("上级菜单模块id，可以为空")
    private Integer parentId = 0;

    @ApiModelProperty("菜单模块备注")
    @Length(max = 200, message = "菜单模块备注需要在200个字之间")
    private String desc;
}
