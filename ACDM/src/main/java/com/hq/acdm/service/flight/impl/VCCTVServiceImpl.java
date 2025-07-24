package com.hq.acdm.service.flight.impl;

import com.hq.acdm.dao.flight.VCCTVMapper;
import com.hq.acdm.model.flight.VCCTV;
import com.hq.acdm.model.flight.VCCTVPopup;
import com.hq.acdm.service.flight.VCCTVService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("VCCTVService")
public class VCCTVServiceImpl implements VCCTVService {
    @Resource
    private com.hq.acdm.dao.flight.VCCTVMapper cCCTVMapper;

    @Override
    public List<VCCTV> queryList(Map params) {
        System.out.println("------------BaggageFlightServiceImpl-----------------");
        List<VCCTV> list = cCCTVMapper.queryList(params);
        System.out.println(list);
        return list;
    }
}

