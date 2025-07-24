package com.hq.acdm.service.flight;

import com.hq.acdm.model.flight.VCCTVPopup;

import java.util.List;
import java.util.Map;

public interface VCCTVPopupService {
    List<VCCTVPopup> query(Map params);
}
