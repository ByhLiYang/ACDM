package com.hq.acdm.service.statistics.cdmTobt.impl;

import com.hq.acdm.service.statistics.cdmTobt.CdmTobtService;
import org.springframework.stereotype.Service;
import com.hq.acdm.model.statistics.cdmTobt.CdmTobt;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
@Service("CdmTobtService")
public class CdmTobtServiceImpl implements CdmTobtService {
    @Resource
    private com.hq.acdm.dao.statistics.cdmToBtMapper cdmToBtMapper;

    @Override
    public List<CdmTobt> queryCdmTobt(Map params) {
        System.out.println("------------BaggageFlightServiceImpl-----------------");
        List<CdmTobt> list = cdmToBtMapper.queryCdmTobt(params);
        System.out.println(list);
        return list;
    }
}
