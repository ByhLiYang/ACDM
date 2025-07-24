package com.hq.acdm.service.index;

import com.hq.acdm.model.index.CompanyDuty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/10/22 13:02
 * @Description
 */
public interface CompanyDutyService {
    int insert(CompanyDuty record);
    int updateByPrimaryKeySelective(CompanyDuty record);
    int deleteByPrimaryKey(BigDecimal id);
    List<CompanyDuty> getRecordByDate(String dutyDate);
    List<CompanyDuty> getAllRecord();
    List<CompanyDuty> selectOrderByDate();
    List<CompanyDuty> maxId();
}
