package com.hq.acdm.service.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TNodeConfigInfo;
import com.hq.acdm.model.realtimeSituation.TNodeConfigInfoExample;
import org.apache.ibatis.annotations.Param;
import com.hq.acdm.vo.realtimeSituation.NodeInfoVo;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface TNodeConfigInfoService {

    public int insert(TNodeConfigInfo record);

    public int updateByPrimaryKeySelective(TNodeConfigInfo record);

    public int deleteByPrimaryKey(String id);

    public List<TNodeConfigInfo> selectByExample(TNodeConfigInfoExample example);

    public List<NodeInfoVo> selectAllNode();

    public List<TNodeConfigInfo> selectAllNodeConfigInfo(@Param("params") Map params);

    public int updateAllNodeIsAvailabl(@Param("node") String node);
}
