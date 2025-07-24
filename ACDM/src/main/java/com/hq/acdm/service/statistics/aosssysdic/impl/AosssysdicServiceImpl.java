package com.hq.acdm.service.statistics.aosssysdic.impl;

import com.hq.acdm.dao.statistics.AosssysdicMapper;
import com.hq.acdm.model.statistics.aosssysdic.Aosssysdic;
import com.hq.acdm.service.statistics.aosssysdic.AosssysdicService;
import com.hq.acdm.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AosssysdicServiceImpl implements AosssysdicService {

    @Autowired
    private AosssysdicMapper aosssysdicMapper;

    @Override
    public List<Aosssysdic> selectParamtypeList() {
        return aosssysdicMapper.selectParamtypeList();
    }

    @Override
    public List<Aosssysdic> selectAllSysdic() {
        return aosssysdicMapper.selectAllSysdic();
    }

    @Override
    public boolean updateSysDic(Map map) throws Exception {
        String typecode = map.get("typecode")==null ? "":map.get("typecode").toString();
        String paracode = map.get("paracode")==null ? "":map.get("paracode").toString();
        int ressult = aosssysdicMapper.deleteDefinedSysdiclogic(typecode,paracode);
        if(ressult>0){
            aosssysdicMapper.insertDefinedSysdicPhysic(map);
            return true;
        }
        return false;
    }

    @Override
    public List<Aosssysdic> selectDefinedParawvalue(String typecode, String paracode, String parameterName, String parameterDescription) {
        return aosssysdicMapper.selectDefinedParawvalue(typecode,paracode,parameterName,parameterDescription);
    }


}
