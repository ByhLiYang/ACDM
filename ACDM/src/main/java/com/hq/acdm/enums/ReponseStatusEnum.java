package com.hq.acdm.enums;

import lombok.Getter;

/**
 * @Author: lizhifeng
 * @Date: 2018/8/18
 * @Description:
 */
@Getter
public enum ReponseStatusEnum {

    /**
     * 枚举类型
     */
    SUCCESS(0, "成功"),

    PARAM_ERROR(1, "参数错误"),

    LOGIN_EXPIRE(2, "登录过期"),

    NOT_PERMISSION(3, "无权限操作"),

    NOT_FOUND(4, "数据接口不存在"),

    SYSTEM_ERROR(5, "系统内部错误"),

    OTHER_ERROR(6, "其他错误"),

    NULL_POINTER(50, "数据对象为空"),
    ;

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态描述信息
     */
    private String message;

    ReponseStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
