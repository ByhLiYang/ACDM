package com.hq.acdm.dao.sysManager;

import com.hq.acdm.model.realtimeSituation.TOndutyInfo;
import com.hq.acdm.vo.sysManager.*;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public interface OnDutyManageMapper {

    //查询值班机构信息
    List<OnDutyOrgVo> findOnDutyOrgInfo(@Param("params") Map params);

    //查询值班机构根节点信息
    List<OnDutyOrgVo> findOnDutyOrgRootInfo(@Param("params") Map params);

    //所有值班机构信息
    List<Map<String,Object>> findOnDutyOrgAllInfo(@Param("params") Map params);

    //所有值班信息
    List<OnDutyDetailsVo> findOnDutyAllInfo(@Param("params") Map params);

    //根据机构ID查询所有值班信息
    List<OnDutyDetailsVo> findOnDutyAllInfoById(@Param("params") Map params);

    //根据机构ID查询所有值班人员信息用于下拉框
    List<OnDutyUserVo> findOnDutyUser(@Param("params") Map params);

}