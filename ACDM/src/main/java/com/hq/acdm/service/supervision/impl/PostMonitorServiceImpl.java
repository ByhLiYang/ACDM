package com.hq.acdm.service.supervision.impl;

import com.hq.acdm.dao.supervision.PostMonitorMapper;
import com.hq.acdm.service.supervision.PostMonitorService;
import com.hq.acdm.vo.supervision.postMonitor.PostMonitor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/11/07 16:24
 * @Description
 */
@Service
public class PostMonitorServiceImpl implements PostMonitorService{

    @Resource
    private PostMonitorMapper postMonitorMapper;
    @Override
    public List<PostMonitor> findTheDelay() {
        return postMonitorMapper.findTheDelay();
    }

    @Override
    public int findTheDelayCount() {
        return postMonitorMapper.findTheDelayCount();
    }

    @Override
    public List<PostMonitor> findForthe() {
        return postMonitorMapper.findForthe();
    }

    @Override
    public int findFortheCount() {
        return postMonitorMapper.findFortheCount();
    }

    @Override
    public List<PostMonitor> findStartBoarding() {
        return postMonitorMapper.findStartBoarding();
    }

    @Override
    public int findStartBoardingCount() {
        return postMonitorMapper.findStartBoardingCount();
    }

    @Override
    public List<PostMonitor> findRollIn() {
        return postMonitorMapper.findRollIn();
    }

    @Override
    public int findRollInCount() {
        return postMonitorMapper.findRollInCount();
    }

    @Override
    public List<PostMonitor> findRollOut() {
        return postMonitorMapper.findRollOut();
    }

    @Override
    public int findRollOutCount() {
        return postMonitorMapper.findRollOutCount();
    }
}
