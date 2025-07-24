package com.hq.acdm.dao.flight;

import com.hq.acdm.model.flight.AbnormalAlert;
import com.hq.acdm.model.flight.VKeyTimesHis;


import java.util.List;
import java.util.Map;

public interface VKeyTimesHisMapper   {
    List<VKeyTimesHis> query(Map params);
}
