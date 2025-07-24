package com.hq.acdm.service.realtimeSituation.impl;

import com.hq.acdm.dao.realtimeSituation.TFlightEventMapper;
import com.hq.acdm.model.realtimeSituation.TFlightEvent;
import com.hq.acdm.model.realtimeSituation.TFlightEventExample;
import com.hq.acdm.service.realtimeSituation.TFlightEventService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class TFlightEventServiceImpl implements TFlightEventService {

    @Resource
    private TFlightEventMapper tFlightEventMapper;

    @Override
    public int findCountByExample(TFlightEventExample example){
        return tFlightEventMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TFlightEventExample example){
        return tFlightEventMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id){
        return tFlightEventMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TFlightEvent record){
        return tFlightEventMapper.insert(record);
    }

    @Override
    public int insertSelective(TFlightEvent record){
        return tFlightEventMapper.insertSelective(record);
    }

    @Override
    public List<TFlightEvent> selectByExample(TFlightEventExample example){
        return tFlightEventMapper.selectByExample(example);
    }

    @Override
    public TFlightEvent selectByPrimaryKey(String id){
        return tFlightEventMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(@Param("record") TFlightEvent record, @Param("example") TFlightEventExample example){
        return tFlightEventMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(@Param("record") TFlightEvent record, @Param("example") TFlightEventExample example){
        return tFlightEventMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(TFlightEvent record){
        return tFlightEventMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TFlightEvent record){
        return tFlightEventMapper.updateByPrimaryKey(record);
    }
}
