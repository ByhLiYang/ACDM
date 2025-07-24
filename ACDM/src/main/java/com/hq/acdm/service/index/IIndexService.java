package com.hq.acdm.service.index;

import com.hq.acdm.model.index.VDelayFlightSum;
import com.hq.acdm.model.index.VSequenceArrivalFetchrows;
import com.hq.acdm.model.index.VSequenceDepartureFetchrows;
import com.hq.acdm.model.index.Weather;
import com.hq.acdm.vo.index.BaseSituationVo;
import com.hq.acdm.vo.index.DelayFlightVo;
import com.hq.acdm.vo.index.FlightNumVo;
import com.hq.acdm.vo.index.WeatherAndDutyVo;

import java.util.Date;
import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/9/3 0003
 * @Description:
 */
public interface IIndexService {

    /**
     * 获取进港航班序列
     * @return
     */
    List<VSequenceArrivalFetchrows> geVSequenceArrivalFetchrows();

    /**
     * 获取离港航班序列
     * @return
     */
    List<VSequenceDepartureFetchrows> getVSequenceDepartureFetchrows();

    /**
     * 获取今天天气情况
     * @return
     */
    WeatherAndDutyVo selectByWeatherDate();

    /**
     * 获取航班延误信息
     * @return
     */
    List<VDelayFlightSum> getDelayFlight();

    /**
     * 进出港航班
     * @return
     */
    FlightNumVo getInOutBoundFlight(String flag);

    /**
     * 首页基本情况数据
     * @return
     */
    BaseSituationVo getBaseSituation(String company);

}
