package com.hq.acdm.service.sysManager;

import com.hq.acdm.model.realtimeSituation.TOndutyOrgRoot;
import com.hq.acdm.model.realtimeSituation.TOndutyOrg;
import com.hq.acdm.model.realtimeSituation.TOndutyInfo;
import com.hq.acdm.vo.sysManager.*;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface OnDutyManageService {

    //查询值班机构信息
    List<OnDutyOrgVo> findOnDutyOrgInfo(@Param("params") Map params);

    //查询值班机构根节点信息
    List<OnDutyOrgVo> findOnDutyOrgRootInfo(@Param("params") Map params);

    //所有值班机构信息
    List<OnDutyOrgInfoVo> findOnDutyOrgAllInfo(@Param("params") Map params);

    //所有值班信息
    List<OnDutyInfoVo> findOnDutyAllInfo(@Param("params") Map params);

    //所有值班信息
    List<OnDutyDetailsVo> findOnDutyAllInfoById(@Param("params") Map params);

    int insertOndutyRootOrg(TOndutyOrgRoot record);

    int insertOndutyOrg(TOndutyOrg record);

    int insertOndutyInfo(TOndutyInfo record);

    int updateOndutyRootOrg(TOndutyOrgRoot record);

    int updateOndutyOrg(TOndutyOrg record);

    int updateOndutyInfo(TOndutyInfo record);

    int deleteOndutyRootOrg(String id);

    int deleteOndutyOrg(String id);

    int deleteOndutyInfo(String id);

    TOndutyOrgRoot selectOrgRootByPrimaryKey(String id);

    TOndutyOrg selectOrgByPrimaryKey(String id);

    TOndutyInfo selectOndutyInfoByPrimaryKey(String id);

    TOndutyInfo findTOndutyInfo(@Param("params") Map params);

    int updateByOrgIdAndOndutyDate(@Param("params") Map params);

    //根据机构ID查询所有值班人员信息用于下拉框
    List<OnDutyUserVo> findOnDutyUser(@Param("params") Map params);

}
