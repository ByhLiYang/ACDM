package com.hq.acdm.dto.sys;

import com.google.common.collect.Lists;
import com.hq.acdm.model.sys.SysRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/27 0027
 * @Description:
 */
@Getter
@Setter
@ToString
public class RoleDto extends SysRole {

    private List<RoleDto> roleList = Lists.newArrayList();

    public static RoleDto adapt(SysRole sysRole) {
        RoleDto dto = new RoleDto();
        BeanUtils.copyProperties(sysRole, dto);
        return dto;
    }
}
