package com.hq.acdm.service.flight;

import java.util.List;
import java.util.Map;
import com.hq.acdm.model.flight.DailyFlightMaster;
/**
 * @Auther: pengzhanghua
 * @Date: 2018/9/18 10:51
 * @Description:
 */
public interface DailyFlightMasterService {
    /**
     * 获取所有航班公司
     * @return
     */
    List<String> getAllCompany();

    public List<DailyFlightMaster> queryList(Map params)  ;

    public List<Map> queryFlightList(Map params)  ;
}
