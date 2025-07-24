package com.hq.acdm.vo.supervision.managermonitor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @Author lizhifeng
 * @Date 2018/9/17 0017
 * @Description:
 */
@Data
public class FourD {

    private String d0;

    private String d1 = "0";

    private String d2 = "0";

    private String d3 = "0";

    @JsonIgnore
    public String getMyD3(){
        Integer d3 = Integer.parseInt(d1)+Integer.parseInt(d2);
        return String.valueOf(d3);
    }

}
