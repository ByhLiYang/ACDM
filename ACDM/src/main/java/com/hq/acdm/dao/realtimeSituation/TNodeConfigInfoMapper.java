package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TNodeConfigInfo;
import com.hq.acdm.model.realtimeSituation.TNodeConfigInfoExample;
import com.hq.acdm.vo.realtimeSituation.NodeInfoVo;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TNodeConfigInfoMapper {
    int countByExample(TNodeConfigInfoExample example);

    int deleteByExample(TNodeConfigInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TNodeConfigInfo record);

    int insertSelective(TNodeConfigInfo record);

    List<TNodeConfigInfo> selectByExample(TNodeConfigInfoExample example);

    TNodeConfigInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TNodeConfigInfo record, @Param("example") TNodeConfigInfoExample example);

    int updateByExample(@Param("record") TNodeConfigInfo record, @Param("example") TNodeConfigInfoExample example);

    int updateByPrimaryKeySelective(TNodeConfigInfo record);

    int updateByPrimaryKey(TNodeConfigInfo record);

    public List<NodeInfoVo> selectAllNode();

    public List<TNodeConfigInfo> selectAllNodeConfigInfo(@Param("params") Map params);

    public int updateAllNodeIsAvailabl(@Param("id") String id,@Param("isavailabl") String isavailabl);
}