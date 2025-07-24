package com.hq.acdm.service.flight.impl;

import com.hq.acdm.dao.flight.VStartFlightLvMapper;
import com.hq.acdm.service.flight.VStartFlightLvService;
import com.hq.acdm.vo.flight.VStartFlightLvVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

/**
 * @Auther: pengzhanghua
 * @Date: 2018/9/18 14:53
 * @Description:
 */
@Service("VStartFlightLvService")
public class VStartFlightLvServiceImpl implements VStartFlightLvService {

    @Resource
    private VStartFlightLvMapper vStartFlightLvMapper;

    @Override
    public List<VStartFlightLvVo> checkFightRegularity(Map map) {
        List<VStartFlightLvVo> vStartFlightLvVos = vStartFlightLvMapper.checkFightRegularity(map);
        for (int i = 0; i <vStartFlightLvVos.size() ; i++) {
           if(vStartFlightLvVos.get(i).getUnnormal()==0){
               vStartFlightLvVos.get(i).setNormalRate(100+"%");
           }else{
               NumberFormat numberFormat = NumberFormat.getInstance();
               numberFormat.setMaximumFractionDigits(0);
               String result = numberFormat.format((float)vStartFlightLvVos.get(i).getNormal()/(float)vStartFlightLvVos.get(i).getExecutecount()*100)+"%";
               vStartFlightLvVos.get(i).setNormalRate(result);
           }
        }
        return vStartFlightLvVos;
    }
}
