package com.hq.acdm.dao.index;

import com.hq.acdm.model.index.VDelayFlightSum;
import com.hq.acdm.vo.supervision.managermonitor.FourD;

import java.util.List;

public interface VDelayFlightSumMapper {
    int insert(VDelayFlightSum record);

    int insertSelective(VDelayFlightSum record);

    List<VDelayFlightSum> getRecord();

    Integer getDelayTotal();

    FourD getDateName();
}