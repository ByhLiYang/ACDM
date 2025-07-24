package com.hq.acdm.service.index.impl;

import com.hq.acdm.model.index.VSequenceArrivalFetchrows;
import com.hq.acdm.service.index.IIndexService;
import com.hq.acdm.test.TestBase;
import com.hq.acdm.vo.index.BaseSituationVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author lizhifeng
 * @Date 2018/9/4 0004
 * @Description:
 */
public class IndexServiceImplTest extends TestBase{

    @Autowired
    private IndexServiceImpl indexService;

    @Test
    public void geVSequenceArrivalFetchrows() throws Exception {
        List<VSequenceArrivalFetchrows> vsList = indexService.geVSequenceArrivalFetchrows();
       // Assert.assertEquals  assertNotEquals  assertNotNull  assertTrue

    }

    @Test
    public void getVSequenceDepartureFetchrows() throws Exception {
    }

    @Test
    public void selectByWeatherDate() throws Exception {
    }

    @Test
    public void getDelayFlight() throws Exception {
    }

    @Test
    public void getInOutBoundFlight() throws Exception {
    }

    @Test
    public void getBaseSituation(String company) throws Exception {
        BaseSituationVo baseSituation = indexService.getBaseSituation(company);
        Assert.assertNotNull(baseSituation);
    }

}