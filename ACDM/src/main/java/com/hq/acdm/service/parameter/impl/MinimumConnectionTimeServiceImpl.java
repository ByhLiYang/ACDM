package com.hq.acdm.service.parameter.impl;

import com.hq.acdm.dao.parameter.MinimumConnectionTimeMapper;
import com.hq.acdm.model.parameter.VMinimumConnectionTime;
import com.hq.acdm.service.parameter.MinimumConnectionTimeService;
import com.hq.acdm.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/10/18 14:51
 * @Description 最小过站时间管理
 */
@Service
public class MinimumConnectionTimeServiceImpl implements MinimumConnectionTimeService {
    @Resource
    private MinimumConnectionTimeMapper minimumConnectionTimeMapper;
    /**
     *  查询最小过站时间
     * @return
     */
    @Override
    public List<VMinimumConnectionTime> findMinimumConnectionTime() {
        return minimumConnectionTimeMapper.findMinimumConnectionTime();
    }
    /**
     *  修改最小过站时间
     * @return
     */
    @Override
    public int updateMinimumConnectionTime(VMinimumConnectionTime vMinimumConnectionTime) {
        if (vMinimumConnectionTime.getDuration()>0&& StringUtil.isAllNotEmpty(vMinimumConnectionTime.getAirline(),vMinimumConnectionTime.getAircrafttype())){
            vMinimumConnectionTime.setUpdatetime(new Date());
            return minimumConnectionTimeMapper.updateMinimumConnectionTime(vMinimumConnectionTime);
        }
        return  0;
    }
    /**
     *  删除时将状态改为‘0’
     * @return
     */
    @Override
    public int updateForDelete(VMinimumConnectionTime vMinimumConnectionTime) {
        if (StringUtil.isAllNotEmpty(vMinimumConnectionTime.getAirline(),vMinimumConnectionTime.getAircrafttype())) {
            vMinimumConnectionTime.setUpdatetime(new Date());
            return minimumConnectionTimeMapper.updateForDelete(vMinimumConnectionTime);
        }
        return 0;
    }
    /**
     *  新增最小过站时间
     * @return
     */
    @Override
    public int insertMinimumConnectionTime(VMinimumConnectionTime vMinimumConnectionTime) {
        if (vMinimumConnectionTime.getDuration()>0&& StringUtil.isAllNotEmpty(vMinimumConnectionTime.getAirline(),vMinimumConnectionTime.getAircrafttype())){
            vMinimumConnectionTime.setUpdatetime(new Date());
            int result = minimumConnectionTimeMapper.updateForRecover(vMinimumConnectionTime);
            if(result==0){
                return minimumConnectionTimeMapper.insertMinimumConnectionTime(vMinimumConnectionTime);
            }
            return result;
        }
        return 0;
    }
}
