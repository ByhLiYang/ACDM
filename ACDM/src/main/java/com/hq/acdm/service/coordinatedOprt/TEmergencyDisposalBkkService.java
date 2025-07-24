package com.hq.acdm.service.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.TEmergencyDisposalBkkVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface TEmergencyDisposalBkkService {

    List<TEmergencyDisposalBkkVo> findTEmergencyDisposalBkk(@Param("params") Map params);



}
