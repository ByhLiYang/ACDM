package com.hq.acdm.dao.flight;

import com.hq.acdm.model.flight.VCCTV;
import com.hq.acdm.model.flight.VCCTVPopup;
//import com.hq.acdm.model.flight.VCCTVPopupExample;

import org.apache.ibatis.annotations.Param;
import java.util.*;
import org.apache.ibatis.annotations.Param;

public interface VCCTVPopupMapper  {
    //登机口监管
    List<VCCTVPopup> queryList(@Param("params") Map params);
}