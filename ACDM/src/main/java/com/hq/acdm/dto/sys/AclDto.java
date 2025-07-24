package com.hq.acdm.dto.sys;

import com.hq.acdm.model.sys.SysAcl;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Getter
@Setter
@ToString
public class AclDto extends SysAcl {

    /** 是否要默认选中 **/
    private boolean checked = false;

    /** 是否有权限操作 **/
    private boolean hasAcl = false;

    public static AclDto adapt(SysAcl acl) {
        AclDto dto = new AclDto();
        BeanUtils.copyProperties(acl, dto);
        return dto;
    }
}
