package com.hq.acdm.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author lizhifeng
 * @Date 2018/8/28 0028
 * @Description:
 */
@Data
public class LoginResponseVo {
    /*private Integer id;*/
    private String id;

    @JsonProperty("nickName")
    private String username;

    private String airline;

    private String dept;

    private String telNum;

    private String ssNum;
}
