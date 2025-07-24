package com.hq.acdm.service.statistics.detainedPassage.impl;

import com.hq.acdm.model.statistics.detainedPassage.DetainedPassage;
import com.hq.acdm.service.statistics.detainedPassage.DetainedPassageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
@Service("DetainedPassageService")
public class DetainedPassageServiceImpl implements DetainedPassageService {
    @Resource
    private com.hq.acdm.dao.statistics.detainedPassageMapper detainedPassageMapper;

    @Override
    public List<DetainedPassage> queryDetainedPassage(Map params) {
        System.out.println("------------BaggageFlightServiceImpl-----------------");
        List<DetainedPassage> list = detainedPassageMapper.queryDetainedPassage(params);
        System.out.println(list);
        return list;
    }

    //登机异常
    @Override
    public List<DetainedPassage> queryAnomalyPassage(Map params){
        System.out.println("------------BaggageFlightServiceImpl-----------------");
        List<DetainedPassage> list = detainedPassageMapper.queryAnomalyPassage(params);
        System.out.println(list);
        return list;
    }
}
