package com.hq.acdm.model.specialCase.infoPublish;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author wangshuhao
 * @date 2018/11/23 0023 13:41
 */
@Getter
@Setter
public class infoPublish {
    private String CONTENT;
    private Date CREATE_DATE;
    private Date EFFECTIVE_DATE;
    private Date EXPIRE_DATE;
    private String CREATE_PERSON;
}
