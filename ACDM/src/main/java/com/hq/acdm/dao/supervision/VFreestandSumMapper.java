package com.hq.acdm.dao.supervision;

import com.hq.acdm.model.supervision.managermonitor.VFreestandSum;

import java.util.List;

public interface VFreestandSumMapper {
    int insert(VFreestandSum record);

    int insertSelective(VFreestandSum record);

    List<VFreestandSum> getAll();

    Integer getFreeTotal();
}