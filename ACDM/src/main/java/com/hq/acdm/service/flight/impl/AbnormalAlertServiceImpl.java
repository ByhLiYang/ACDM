package com.hq.acdm.service.flight.impl;

import com.hq.acdm.dao.flight.AbnormalAlertMapper;
import com.hq.acdm.model.flight.AbnormalAlert;
import com.hq.acdm.service.flight.AbnormalAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("abnormalAlertService")
public class AbnormalAlertServiceImpl implements AbnormalAlertService {

    public static final String QUERY_DATE = "queryDate";

    @Autowired
    AbnormalAlertMapper abnormalAlertMapper;

    @Override
    public List<AbnormalAlert> query(Map params) {
        return abnormalAlertMapper.selecAbnormalAlert(params);
    }
}
