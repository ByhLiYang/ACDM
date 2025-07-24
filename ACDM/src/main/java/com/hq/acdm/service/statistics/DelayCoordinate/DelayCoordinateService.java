package com.hq.acdm.service.statistics.DelayCoordinate;

import com.hq.acdm.model.statistics.delayCoordinate.DelayCoordinateModel;

import java.util.List;

/**
 * @author wangshuhao
 * @date 2018/12/6 0006 13:46
 */
public interface DelayCoordinateService {
    List<DelayCoordinateModel> queryDelay();
}
