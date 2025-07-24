package com.hq.acdm.service.timer.Historical_Flight_Master;

import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightAddDetails;
import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightAddDetailsMore;
import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightMaster;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/9 0009 15:40
 */
public interface HistoricalFlightMasterService {
    DailyFlightMaster countDFM();
    List<DailyFlightMaster> queryDFM();
    int insertHistoricalFlightMaster(DailyFlightMaster dailyFlightMaster);
    int deleteHistorical(Map<String,Object> map);
    int deleteDFM(Map<String,Object> map);
    DailyFlightMaster queryByCondition(Map<String,Object> map);
    List<DailyFlightAddDetails> queryDFAD();
    DailyFlightAddDetails countDFAD();
    int deleteHFAD(Map<String,Object> map);
    int insertDFAM(Map<String,Object> map);
    int deleteDFAD(Map<String,Object> map);
    int deleteDFADM(Map<String,Object> map);
    int insertHFADM(Map<String,Object> map);
    int deleteHFADM(Map<String,Object> map);
    List<DailyFlightAddDetailsMore> queryDFADM();
    DailyFlightAddDetailsMore countDFADM();
    DailyFlightAddDetails queryHFADByCondition(Map<String,Object> map);
    DailyFlightAddDetailsMore queryHFADMByCondition(Map<String,Object> map);
}
