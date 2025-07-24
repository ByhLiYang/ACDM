package com.hq.acdm.service.statistics.estimatedTaxiTimeAccuracy.impl;


import com.hq.acdm.dao.statistics.EstimatedTaxiTimeAccuracyMapper;
import com.hq.acdm.model.statistics.estimatedTaxiTimeAccuracy.EstimatedTaxiTimeAccuracy;
import com.hq.acdm.service.statistics.estimatedTaxiTimeAccuracy.EstimatedTaxiTimeAccuracyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wangshuhao
 * @Date: 2018/9/19 10:38
 * @Description:
 */
@Service("EstimatedTaxiTimeAccuracyService")
public class EstimatedTaxiTimeAccuracyServiceImpl implements EstimatedTaxiTimeAccuracyService{
    @Resource
    private EstimatedTaxiTimeAccuracyMapper estimatedTaxiAccuracyMapper;

    @Override
    public List<EstimatedTaxiTimeAccuracy> queryEstimatedTaxiTimeAccuracyInfo(Map params) {

        List<EstimatedTaxiTimeAccuracy> estimatedTaxiTimeAccuracies = estimatedTaxiAccuracyMapper.queryEstimatedTaxiTimeAccuracyInfo(params);
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
        for (int i=0;i<estimatedTaxiTimeAccuracies.size();i++){
            double d1 = 0.00;
            double d2 = 0.00;
            double d3 = 0.00;
            if("A".equals(params.get("taxiType"))){
                d1=estimatedTaxiTimeAccuracies.get(i).getInbound();
                d2=estimatedTaxiTimeAccuracies.get(i).getTotal();
                if (d2 == 0){
                    d3 = 0.00;
                }else{
                    d3 = d1/d2*100;
                }
            }else if("D".equals(params.get("taxiType"))){
                d1=estimatedTaxiTimeAccuracies.get(i).getOutbound();
                d2=estimatedTaxiTimeAccuracies.get(i).getTotal();
                estimatedTaxiTimeAccuracies.get(i).setInbound(estimatedTaxiTimeAccuracies.get(i).getOutbound());
                if (d2 == 0){
                    d3 = 0.00;
                }else{
                    d3 = d1/d2*100;
                }

            }else{
                d1=estimatedTaxiTimeAccuracies.get(i).getInbound()+estimatedTaxiTimeAccuracies.get(i).getOutbound();
                d2=estimatedTaxiTimeAccuracies.get(i).getTotal();
                estimatedTaxiTimeAccuracies.get(i).setInbound(estimatedTaxiTimeAccuracies.get(i).getOutbound()+estimatedTaxiTimeAccuracies.get(i).getInbound());
                if (d2 == 0){
                    d3 = 0.00;
                }else{
                    d3 = d1/d2*100;
                }
            }

            estimatedTaxiTimeAccuracies.get(i).setPercentage(df.format(d3).toString()+"%");
        }
        return estimatedTaxiTimeAccuracies;
    }
}
