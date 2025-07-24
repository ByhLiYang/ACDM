package com.hq.acdm.enums.sys;

import lombok.Getter;

/**
 * @Author lizhifeng
 * @Date 2018/8/26 0026
 * @Description:
 */
@Getter
public enum RoleEnum {
    /**
     * 角色枚举
     */
    MANAGER(1, "管理员类型"),

    OTHER(2, "其他类型"),
    ;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态描述信息
     */
    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
