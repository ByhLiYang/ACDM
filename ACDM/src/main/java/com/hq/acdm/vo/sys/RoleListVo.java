package com.hq.acdm.vo.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hq.acdm.model.sys.SysRole;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/29 0029
 * @Description:
 */
@Data
public class RoleListVo {
    private Integer id;

    private Integer parentId;

    private String name;

    private String enName;

    private Integer sort;

    private Integer usable;

    private String remarks;

    private List<RoleListVo> children;

    @JsonIgnore
    private String roleLevel;

    @JsonIgnore
    public static RoleListVo adapt(SysRole role) {
        RoleListVo vo = new RoleListVo();
        BeanUtils.copyProperties(role, vo);
        return vo;
    }
}
