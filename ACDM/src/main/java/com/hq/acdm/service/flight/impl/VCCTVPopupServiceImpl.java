package com.hq.acdm.service.flight.impl;

import com.hq.acdm.dao.flight.VCCTVMapper;
import com.hq.acdm.dao.flight.VCCTVPopupMapper;
import com.hq.acdm.model.flight.VCCTV;
import com.hq.acdm.model.flight.VCCTVPopup;
import com.hq.acdm.service.flight.VCCTVPopupService;
import com.hq.acdm.service.flight.VCCTVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("VCCTVPopupService")
public class VCCTVPopupServiceImpl   implements VCCTVPopupService {

    @Autowired
    private VCCTVPopupMapper vcctvPopupMapper;
    //AOBT--OUT 出港==>D ; AIBT--IN 进港==>A
    public static final String A_OR_D = "aOrD"; //出入港

    public static final String STAND = "stand"; //机位号

    public static final String OPERATIONAL_DATE = "operationalDate"; //操作时间



    @Override
    public List<VCCTVPopup> query(Map params) {
        System.out.println("------------BaggageFlightServiceImpl-----------------");
        List<VCCTVPopup> list = vcctvPopupMapper.queryList(params);
        System.out.println(list);
        return list;
    }
}
