package com.hq.acdm.dao.flight;

import com.hq.acdm.model.flight.AbnormalAlert;


import java.util.List;
import java.util.Map;

public interface AbnormalAlertMapper  {
    List<AbnormalAlert> selecAbnormalAlert(Map params);
}
