package com.hq.acdm.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hq.acdm.enums.ReponseStatusEnum;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>(10);
        result.put("status", status);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status,T data){
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    /**
     * 使之不在json序列化结果当中
     * @return
     */
    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ReponseStatusEnum.SUCCESS.getCode();
    }

    public int getStatus(){
        return status;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }


    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ReponseStatusEnum.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ReponseStatusEnum.SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T data){
        return new ServerResponse<T>(ReponseStatusEnum.SUCCESS.getCode(),msg,data);
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ReponseStatusEnum.SUCCESS.getCode(),msg);
    }

    public static <T> ServerResponse<T> createByParamError(){
        return new ServerResponse<T>(ReponseStatusEnum.PARAM_ERROR.getCode(),ReponseStatusEnum.PARAM_ERROR.getMessage());
    }

    public static <T> ServerResponse<T> createByParamError(String message){
        return new ServerResponse<T>(ReponseStatusEnum.PARAM_ERROR.getCode(),message);
    }

    public static <T> ServerResponse<T> createByNotFoundError(){
        return new ServerResponse<T>(ReponseStatusEnum.NOT_FOUND.getCode(),ReponseStatusEnum.NOT_FOUND.getMessage());
    }

    public static <T> ServerResponse<T> createByNullPointerError(){
        return new ServerResponse<T>(ReponseStatusEnum.NULL_POINTER.getCode(),ReponseStatusEnum.NULL_POINTER.getMessage());
    }

    public static <T> ServerResponse<T> createByLoginExpire(){
        return new ServerResponse<T>(ReponseStatusEnum.LOGIN_EXPIRE.getCode(),ReponseStatusEnum.LOGIN_EXPIRE.getMessage());
    }

    public static <T> ServerResponse<T> createByNotPermission(){
        return new ServerResponse<T>(ReponseStatusEnum.NOT_PERMISSION.getCode(),ReponseStatusEnum.NOT_PERMISSION.getMessage());
    }

    public static <T> ServerResponse<T> createBySystemError(){
        return new ServerResponse<T>(ReponseStatusEnum.SYSTEM_ERROR.getCode(),ReponseStatusEnum.SYSTEM_ERROR.getMessage());
    }

    public static <T> ServerResponse<T> createByOtherError(String message){
        return new ServerResponse<T>(ReponseStatusEnum.OTHER_ERROR.getCode(),message);
    }


}
