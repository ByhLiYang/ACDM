package com.hq.acdm.vo.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import com.hq.acdm.model.sys.SysAcl;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/28 0028
 * @Description:
 */
@Data
public class AclListVo {
    private Integer id;

    @JsonProperty("parentId")
    private Integer aclModuleId;

    @JsonProperty("sort")
    private Integer seq;

    private String name;

    @JsonProperty("code")
    private String url;

    private Integer type;

    @JsonProperty("usable")
    private Integer status;

    @JsonProperty("remarks")
    private String remark;

    List<AclListVo> children = Lists.newArrayList();

    @JsonIgnore
    private String code;

    @JsonIgnore
    public static AclListVo adapt(SysAcl acl) {
        AclListVo vo = new AclListVo();
        BeanUtils.copyProperties(acl, vo);
        return vo;
    }
}
