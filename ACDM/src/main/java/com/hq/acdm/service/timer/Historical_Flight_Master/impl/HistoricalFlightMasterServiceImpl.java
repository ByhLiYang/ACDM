package com.hq.acdm.service.timer.Historical_Flight_Master.impl;

import com.hq.acdm.dao.timer.Historical_Flight_Master.HistoricalFlightMasterMapper;
import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightAddDetails;
import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightAddDetailsMore;
import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightMaster;
import com.hq.acdm.service.timer.Historical_Flight_Master.HistoricalFlightMasterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/9 0009 15:41
 */
@Service("HistoricalFlightMasterService")
public class HistoricalFlightMasterServiceImpl implements HistoricalFlightMasterService {
    @Resource
    private HistoricalFlightMasterMapper historicalFlightMasterMapper;
    @Override
    public DailyFlightMaster countDFM() {
        return historicalFlightMasterMapper.countDFM();
    }

    @Override
    public List<DailyFlightMaster> queryDFM() {
        return historicalFlightMasterMapper.queryDFM();
    }

    @Override
    public int insertHistoricalFlightMaster(DailyFlightMaster dailyFlightMaster) {
        return historicalFlightMasterMapper.insertHistoricalFlightMaster(dailyFlightMaster);
    }

    @Override
    public int deleteHistorical(Map<String, Object> map) {
        return historicalFlightMasterMapper.deleteHistorical(map);
    }

    @Override
    public int deleteDFM(Map<String, Object> map) {
        return historicalFlightMasterMapper.deleteDFM(map);
    }

    @Override
    public DailyFlightMaster queryByCondition(Map<String, Object> map) {
        return historicalFlightMasterMapper.queryByCondition(map);
    }

    @Override
    public List<DailyFlightAddDetails> queryDFAD() {
        return historicalFlightMasterMapper.queryDFAD();
    }

    @Override
    public DailyFlightAddDetails countDFAD() {
        return historicalFlightMasterMapper.countDFAD();
    }

    @Override
    public int deleteHFAD(Map<String, Object> map) {
        return historicalFlightMasterMapper.deleteHFAD(map);
    }

    @Override
    public int insertDFAM(Map<String, Object> map) {
        return historicalFlightMasterMapper.insertDFAM(map);
    }

    @Override
    public int deleteDFAD(Map<String, Object> map) {
        return historicalFlightMasterMapper.deleteDFAD(map);
    }

    @Override
    public int deleteDFADM(Map<String, Object> map) {
        return historicalFlightMasterMapper.deleteDFADM(map);
    }

    @Override
    public int insertHFADM(Map<String, Object> map) {
        return historicalFlightMasterMapper.insertHFADM(map);
    }

    @Override
    public int deleteHFADM(Map<String, Object> map) {
        return historicalFlightMasterMapper.deleteHFADM(map);
    }

    @Override
    public List<DailyFlightAddDetailsMore> queryDFADM() {
        return historicalFlightMasterMapper.queryDFADM();
    }

    @Override
    public DailyFlightAddDetailsMore countDFADM() {
        return historicalFlightMasterMapper.countDFADM();
    }

    @Override
    public DailyFlightAddDetails queryHFADByCondition(Map<String, Object> map) {
        return historicalFlightMasterMapper.queryHFADByCondition(map);
    }

    @Override
    public DailyFlightAddDetailsMore queryHFADMByCondition(Map<String, Object> map) {
        return historicalFlightMasterMapper.queryHFADMByCondition(map);
    }

}

