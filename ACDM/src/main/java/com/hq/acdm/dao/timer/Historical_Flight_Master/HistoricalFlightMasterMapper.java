package com.hq.acdm.dao.timer.Historical_Flight_Master;

import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightAddDetails;
import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightAddDetailsMore;
import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightMaster;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/9 0009 15:42
 */
public interface HistoricalFlightMasterMapper {
    DailyFlightMaster countDFM();
    List<DailyFlightMaster> queryDFM();
    int insertHistoricalFlightMaster(@Param("params") DailyFlightMaster dailyFlightMaster);
    int deleteHistorical(@Param("params") Map<String,Object> map);
    int deleteDFM(@Param("params") Map<String,Object> map);
    DailyFlightMaster queryByCondition(@Param("params") Map<String,Object> map);
    List<DailyFlightAddDetails> queryDFAD();
    int deleteHFAD(@Param("params") Map<String,Object> map);
    int insertDFAM(@Param("params") Map<String,Object> map);
    int deleteDFAD(@Param("params") Map<String,Object> map);
    DailyFlightAddDetails countDFAD();
    DailyFlightAddDetails queryHFADByCondition(@Param("params") Map<String,Object> map);
    int deleteDFADM(@Param("params") Map<String,Object> map);
    int insertHFADM(@Param("params") Map<String,Object> map);
    int deleteHFADM(@Param("params") Map<String,Object> map);
    List<DailyFlightAddDetailsMore> queryDFADM();
    DailyFlightAddDetailsMore countDFADM();
    DailyFlightAddDetailsMore queryHFADMByCondition(@Param("params") Map<String,Object> map);
    List<DailyFlightMaster> queryLatestRWY();
}
