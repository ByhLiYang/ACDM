package com.hq.acdm.vo.sysManager;

import lombok.Data;

import java.util.List;

@Data
public class OnDutyOrgInfoVo {

    private String id;
    private String orgType;
    private String label;
    private List<OnDutyOrgVo> children;


}
