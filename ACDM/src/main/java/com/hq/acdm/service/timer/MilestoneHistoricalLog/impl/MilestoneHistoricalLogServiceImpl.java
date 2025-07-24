package com.hq.acdm.service.timer.MilestoneHistoricalLog.impl;

import com.hq.acdm.dao.timer.MilestoneHistoricalLog.MilestoneHistoricalLogMapper;
import com.hq.acdm.model.timer.MilestoneHistoricalLog.MilestoneHistoricalLog;
import com.hq.acdm.service.timer.MilestoneHistoricalLog.MilestoneHistoricalLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/12 0012 15:18
 */
@Service("MilestoneHistoricalLogService")
public class MilestoneHistoricalLogServiceImpl implements MilestoneHistoricalLogService {
    @Resource
    private MilestoneHistoricalLogMapper milestoneHistoricalLogMapper;
    @Override
    public MilestoneHistoricalLog countMDL() {
        return milestoneHistoricalLogMapper.countMDL();
    }

    @Override
    public List<MilestoneHistoricalLog> queryMDL() {
        return milestoneHistoricalLogMapper.queryMDL();
    }

    @Override
    public MilestoneHistoricalLog queryMHLByCondition(Map<String, Object> map) {
        return milestoneHistoricalLogMapper.queryMHLByCondition(map);
    }

    @Override
    public int deleteMHL(Map<String, Object> map) {
        return milestoneHistoricalLogMapper.deleteMHL(map);
    }

    @Override
    public int deleteMDL(Map<String, Object> map) {
        return milestoneHistoricalLogMapper.deleteMDL(map);
    }

    @Override
    public int insertMHL(Map<String, Object> map) {
        return milestoneHistoricalLogMapper.insertMHL(map);
    }
}
