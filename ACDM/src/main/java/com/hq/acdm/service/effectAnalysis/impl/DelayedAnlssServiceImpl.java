package com.hq.acdm.service.effectAnalysis.impl;


import com.hq.acdm.dao.effectAnalysis.DelayedAnlssMapper;
import com.hq.acdm.service.effectAnalysis.DelayedAnlssService;
import com.hq.acdm.vo.effectAnalysis.DelayReasonVo;
import com.hq.acdm.vo.effectAnalysis.DelayedAnlssVo;
import com.hq.acdm.vo.effectAnalysis.TAtcDelayStatistics;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class DelayedAnlssServiceImpl implements DelayedAnlssService {

    @Resource
    private DelayedAnlssMapper delayedAnlssMapper;


    @Override
    public List<DelayedAnlssVo> selectDelayedAnlssByDate(@Param("params") Map params) {
        return delayedAnlssMapper.selectDelayedAnlssByDate(params);
    }

    @Override
    public List<DelayedAnlssVo> selectDelayedAnlssByDateHistory(Map params) {
        return delayedAnlssMapper.selectDelayedAnlssByDateHistory(params);
    }

    @Override
    public List<DelayReasonVo> selectDelayedReason(Map params) {
        return delayedAnlssMapper.selectDelayedReason(params);
    }

    @Override
    public List<TAtcDelayStatistics> selectDelayedReasonforCTOT(Map params) {
        return delayedAnlssMapper.selectDelayedReasonforCTOT(params);
    }

    @Override
    public int updateATCReason(TAtcDelayStatistics record) {
        return delayedAnlssMapper.updateATCReason(record);
    }

    @Override
    public int updateReason(DelayedAnlssVo record) {
        return delayedAnlssMapper.updateReason(record);
    }
}
