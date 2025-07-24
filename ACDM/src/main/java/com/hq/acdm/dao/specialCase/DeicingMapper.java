package com.hq.acdm.dao.specialCase;

import com.hq.acdm.model.specialCase.deicing.deicingModel;
import com.hq.acdm.model.specialCase.deicing.stand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/10/31 0031 11:00
 * 除冰管理
 */
public interface DeicingMapper {
    List<deicingModel> selectAll();
    List<deicingModel> selectByPk(@Param("params")Map params);
    List<stand> queryStand();
    int updateDAILY_FLIGHT_ADD_DETAILS(@Param("params")Map params);
    int updateDAILY_FLIGHT_MASTER(@Param("params")Map params);
}
