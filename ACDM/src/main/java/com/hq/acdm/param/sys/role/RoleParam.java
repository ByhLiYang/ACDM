package com.hq.acdm.param.sys.role;

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
public class RoleParam {

    @ApiModelProperty("角色ID，新增时为空")
    private Integer id;

    @ApiModelProperty("父级ID，可以为空")
    private Integer parentId = 0;

    @ApiModelProperty("角色名称")
    @NotBlank(message = "角色名称不可以为空")
    @Length(min = 2, max = 20, message = "角色名称长度需要在2-20个字之间")
    private String name;

    @ApiModelProperty("角色英文名称")
    @Length(max = 20, message = "角色名称长度需要在2-20个字之间")
    private String enName="";

/*    @ApiModelProperty("角色类型，1：管理员角色，2：其他")
    @Min(value = 1, message = "角色类型不合法")
    @Max(value = 2, message = "角色类型不合法")
    private Integer type = 1;*/

    private Integer sort;

    @ApiModelProperty("角色状态，1：可用，0：冻结")
    @NotNull(message = "角色状态不可以为空")
    @Min(value = 0, message = "角色状态不合法")
    @Max(value = 1, message = "角色状态不合法")
    private Integer usable;

    @ApiModelProperty("角色备注")
    @Length(max = 200, message = "角色备注长度需要在200个字符以内")
    private String remarks="";
}
