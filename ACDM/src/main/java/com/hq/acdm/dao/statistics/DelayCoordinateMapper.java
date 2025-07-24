package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.delayCoordinate.DelayCoordinateModel;

import java.util.List;

/**
 * @author wangshuhao
 * @date 2018/12/6 0006 13:49
 */
public interface DelayCoordinateMapper {
    List<DelayCoordinateModel> queryDelay();
}
