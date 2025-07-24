package com.hq.acdm.service.flight;

import com.hq.acdm.model.flight.AbnormalAlert;

import java.util.List;
import java.util.Map;

public interface AbnormalAlertService {
    List<AbnormalAlert> query(Map params);
}
