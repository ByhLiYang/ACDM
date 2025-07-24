package com.hq.acdm.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author lizhifeng
 * @Date 2018/8/28 0028
 * @Description:
 */
@Data
public class AddressBookUsers {
    /*private Integer id;*/
    private String label;

    private String telNum;

    private String ssNum;

    private String acdmNum;

    private boolean isonline;
}
