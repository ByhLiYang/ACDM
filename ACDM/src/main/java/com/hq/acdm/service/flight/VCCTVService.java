package com.hq.acdm.service.flight;

import com.hq.acdm.dao.flight.VCCTVMapper;
import com.hq.acdm.model.flight.VCCTV;
import com.hq.acdm.model.flight.VCCTVPopup;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface VCCTVService {

    List<VCCTV> queryList(Map params);

}
