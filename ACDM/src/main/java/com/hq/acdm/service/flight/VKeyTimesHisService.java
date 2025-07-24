package com.hq.acdm.service.flight;

import com.hq.acdm.model.flight.VKeyTimesHis;

import java.util.List;
import java.util.Map;

public interface VKeyTimesHisService {
    List<VKeyTimesHis> query(Map params);
}
