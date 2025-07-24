package com.hq.acdm.service.abnormal;

import com.hq.acdm.vo.abnormal.DelayLiveVO;
import com.hq.acdm.vo.abnormal.DelayNumberVO;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @Author lizhifeng
 * @Date 2018/9/27 0027
 * @Description:
 */
public interface DelayLiveService {

    DelayLiveVO query(@Param("params") Map params);

    DelayNumberVO getDelayInfoByMobile(@Param("params") Map params);

}
