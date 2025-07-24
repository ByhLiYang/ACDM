package com.hq.acdm.param.sys;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

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
public class AclParam {

    @ApiModelProperty("权限ID，新增时为空")
    private Integer id;

    @ApiModelProperty("权限名称")
    @NotBlank(message = "权限名称不可以为空")
    @Length(min = 2, max = 20, message = "权限点名称长度需要在2-20个字之间")
    private String name;

    @ApiModelProperty("父级ID")
    private Integer parentId = 0;

    @ApiModelProperty("权限点URL")
    @Length(min = 2, max = 100, message = "权限点URL长度需要在2-100个字符之间")
    private String code;

    @ApiModelProperty("权限点的类型 1：菜单，2：按钮，3：功能")
    @NotNull(message = "必须指定权限点的类型")
    @Min(value = 1, message = "权限点类型不合法")
    @Max(value = 3, message = "权限点类型不合法")
    private Integer type;

    @ApiModelProperty("权限在当前模块下的顺序，数字由小到大")
    @NotNull(message = "必须指定权限点的展示顺序")
    private Integer sort;

    @ApiModelProperty("权限点状态 1：正常，0：冻结'")
    @NotNull(message = "必须指定权限点的状态")
    @Min(value = 0, message = "权限点状态不合法")
    @Max(value = 1, message = "权限点状态不合法")
    private Integer usable;

    @ApiModelProperty("权限点备注")
    @Length(max = 200, message = "权限点备注长度需要在200个字符以内")
    private String remarks;
}
