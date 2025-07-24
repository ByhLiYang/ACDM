package com.hq.acdm.service.flight;

import com.hq.acdm.model.flight.FreeStandSum;

import java.util.List;
import java.util.Map;

public interface FreeStandSumService {
    List<FreeStandSum> query(Map params);
}
