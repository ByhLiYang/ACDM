package com.hq.acdm.dao.abnormal;

import com.hq.acdm.vo.abnormal.DelayNumberVO;
import com.hq.acdm.vo.abnormal.FiveD;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author lizhifeng
 * @Date 2018/9/27 0027
 * @Description:
 */
public interface DelayLiveMapper {

    /**
     * 获取离港航班延误
     * @return
     */
    List<FiveD> getTableData1(@Param("params") Map params);

    /**
     * 获取离港航线延误
     * @return
     */
    List<FiveD> getTableData2();

    /**
     * 获取最近进港航班
     * @return
     */
    List<FiveD> getRecentInbound();

    /**
     * 获取最近离港航班
     * @return
     */
    List<FiveD> getRecentOutbound();

    //获取航班延误数据（按延误时长分类）
    Map<String,Object> getDelayInfoByMobile(@Param("params") Map params);

}
