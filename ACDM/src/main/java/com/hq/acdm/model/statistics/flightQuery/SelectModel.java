package com.hq.acdm.model.statistics.flightQuery;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangshuhao
 * @date 2018/10/18 0018 15:08
 */
@Getter
@Setter

public class SelectModel {


    public SelectModel(String label, String value,String relation,boolean flag) {
        this.label = label;
        this.value = value;
        this.relation = relation;
        this.flag = flag;
    }
    private String label;
    private String value;
    private String relation;
    private boolean flag;
}
