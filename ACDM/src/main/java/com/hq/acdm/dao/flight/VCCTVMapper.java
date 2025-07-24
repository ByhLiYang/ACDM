package com.hq.acdm.dao.flight;

import com.hq.acdm.model.flight.VCCTV;
//import com.hq.acdm.model.flight.VCCTVExample;
import java.util.*;
import org.apache.ibatis.annotations.Param;


public interface VCCTVMapper{

        //登机口监管
        List<VCCTV> queryList(@Param("params") Map params);

}