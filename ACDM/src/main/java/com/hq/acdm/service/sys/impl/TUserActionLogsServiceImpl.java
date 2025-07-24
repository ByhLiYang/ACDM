package com.hq.acdm.service.sys.impl;

import com.hq.acdm.dao.sys.TUserActionLogsMapper;
import com.hq.acdm.service.sys.TUserActionLogsService;
import com.hq.acdm.vo.sys.TUserActionLogs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LiFaQiang
 * @date 2019/12/12 15:25
 * @Description
 */
@Service
public class TUserActionLogsServiceImpl implements TUserActionLogsService {

    @Resource
    TUserActionLogsMapper tUserActionLogsMapper;
    @Override
    public int updateActionLogs(TUserActionLogs tual) {
        return tUserActionLogsMapper.insertSelective(tual);
    }
}
