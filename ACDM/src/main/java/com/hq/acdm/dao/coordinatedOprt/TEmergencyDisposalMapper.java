package com.hq.acdm.dao.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.TEmergencyDisposal;
import com.hq.acdm.vo.coordinatedOprt.TEmergencyDisposalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TEmergencyDisposalMapper {
    int countByExample(TEmergencyDisposalExample example);

    int deleteByExample(TEmergencyDisposalExample example);

    int deleteByPrimaryKey(String id);

    int insert(TEmergencyDisposal record);

    int insertSelective(TEmergencyDisposal record);

    List<TEmergencyDisposal> selectByExample(TEmergencyDisposalExample example);

    TEmergencyDisposal selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TEmergencyDisposal record, @Param("example") TEmergencyDisposalExample example);

    int updateByExample(@Param("record") TEmergencyDisposal record, @Param("example") TEmergencyDisposalExample example);

    int updateByPrimaryKeySelective(TEmergencyDisposal record);

    int updateByPrimaryKey(TEmergencyDisposal record);
}