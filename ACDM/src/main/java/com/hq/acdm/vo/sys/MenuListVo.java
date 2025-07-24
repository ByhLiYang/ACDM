package com.hq.acdm.vo.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import com.hq.acdm.model.sys.SysAclModule;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/28 0028
 * @Description:
 */
@Data
public class MenuListVo {

    private Integer id;

    private Integer parentId;

    @JsonProperty("sort")
    private Integer seq;

    private String name;

    private String href;

    private String icon;

    List<MenuListVo> children = Lists.newArrayList();

    @JsonProperty("isShow")
    private Integer status;

    @JsonIgnore
    private String moduleLevel;

    @JsonIgnore
    public static MenuListVo adapt(SysAclModule aclModule) {
        MenuListVo vo = new MenuListVo();
        BeanUtils.copyProperties(aclModule, vo);
        return vo;
    }


}
