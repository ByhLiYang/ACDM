package com.hq.acdm.service.index.impl;

import com.hq.acdm.dao.index.CompanyDutyMapper;
import com.hq.acdm.model.index.CompanyDuty;
import com.hq.acdm.service.index.CompanyDutyService;
import com.hq.acdm.util.DateTimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/10/22 15:15
 * @Description
 */
@Service
public class CompanyDutyServiceImpl implements CompanyDutyService{
    @Resource
    private CompanyDutyMapper companyDutyMapper;
    @Override
    public int insert(CompanyDuty record) {
        record.setOperateTime(new Date());
        return companyDutyMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(CompanyDuty record) {
        record.setOperateTime(new Date());
        return companyDutyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(BigDecimal id) {
        return companyDutyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CompanyDuty> getRecordByDate(String dutyDate) {
        if(null != dutyDate){
            return companyDutyMapper.getRecordByDate(dutyDate);
        }
        return null;
    }

    @Override
    public List<CompanyDuty> getAllRecord() {
        return companyDutyMapper.getAllRecord();
    }

    @Override
    public List<CompanyDuty> selectOrderByDate() {
        return companyDutyMapper.selectOrderByDate();
    }

    @Override
    public List<CompanyDuty> maxId() {
        return companyDutyMapper.maxId();
    }
}
