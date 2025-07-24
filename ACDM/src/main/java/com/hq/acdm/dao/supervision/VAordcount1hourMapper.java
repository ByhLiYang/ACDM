package com.hq.acdm.dao.supervision;

import com.hq.acdm.model.supervision.managermonitor.VAordcount1hour;

import java.util.List;

public interface VAordcount1hourMapper {
    int insert(VAordcount1hour record);

    int insertSelective(VAordcount1hour record);

    List<VAordcount1hour> get();

    /**
     * 获取过去一小时出发的航班数量
     * @return
     */
    int getLastFlightNum_D();

    /**
     * 获取过去一小时降落的航班数量
     * @return
     */
    int getLastFlightNum_A();


}