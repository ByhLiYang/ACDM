package com.hq.acdm.dao.index;

import com.hq.acdm.model.index.CompanyDuty;
import java.math.BigDecimal;
import java.util.List;

public interface CompanyDutyMapper {

    int deleteByPrimaryKey(BigDecimal id);

    int insert(CompanyDuty record);

    CompanyDuty selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(CompanyDuty record);

    int updateByPrimaryKey(CompanyDuty record);

    List<CompanyDuty> getTodayRecord();

    List<CompanyDuty> getRecordByDate(String dutyDate);

    List<CompanyDuty> getAllRecord();

    List<CompanyDuty> selectOrderByDate();

    List<CompanyDuty> maxId();
}