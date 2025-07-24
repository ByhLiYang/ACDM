package com.hq.acdm.dao.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.FlowControlInfoTControlInfoVo;
import com.hq.acdm.vo.coordinatedOprt.FlowControlInfoTMdrsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface FlowControlInformationMapper {

    List<FlowControlInfoTMdrsVo> findFlowControlInfoTMdrs(@Param("params") Map params);

    List<FlowControlInfoTControlInfoVo> findFlowControlInfoTControlInfo(@Param("params") Map params);

}
