package com.hq.acdm.service.rscMonitors;

import com.hq.acdm.model.rscMonitors.TEarlyDeicing;
import com.hq.acdm.vo.rscMonitors.EarlyDeicingVo;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2020/12/17 11:07
 * @Description
 */
public interface DeicingScheduleService {
    List<TEarlyDeicing> selectByDate(String execDate,String type);
    int updateByFlno(TEarlyDeicing record);
    int updateStand(TEarlyDeicing record);
    List<String> selectStand(TEarlyDeicing record);
    List<EarlyDeicingVo> selectFltLocation(String execDate);
}
