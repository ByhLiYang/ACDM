package com.hq.acdm.dao.flight;

import com.hq.acdm.model.flight.VStartFlightLv;
import com.hq.acdm.vo.flight.VStartFlightLvVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface VStartFlightLvMapper {
    int insert(VStartFlightLv record);

    int insertSelective(VStartFlightLv record);

    List<VStartFlightLvVo> checkFightRegularity(@Param("record") Map record);
}