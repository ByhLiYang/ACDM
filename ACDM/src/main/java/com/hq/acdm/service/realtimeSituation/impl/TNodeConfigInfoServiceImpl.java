package com.hq.acdm.service.realtimeSituation.impl;

import com.hq.acdm.dao.realtimeSituation.TNodeConfigInfoMapper;
import com.hq.acdm.model.realtimeSituation.TNodeConfigInfo;
import com.hq.acdm.model.realtimeSituation.TNodeConfigInfoExample;
import com.hq.acdm.service.realtimeSituation.TNodeConfigInfoService;
import com.hq.acdm.vo.realtimeSituation.NodeInfoVo;
import org.apache.ibatis.annotations.Param;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class TNodeConfigInfoServiceImpl implements TNodeConfigInfoService {

    @Resource
    private TNodeConfigInfoMapper tNodeConfigInfoMapper;

    @Override
    public int insert(TNodeConfigInfo record){
        return tNodeConfigInfoMapper.insert(record);
    }
    @Override
    public int updateByPrimaryKeySelective(TNodeConfigInfo record){
        return tNodeConfigInfoMapper.updateByPrimaryKeySelective(record);
    }
    @Override
    public int deleteByPrimaryKey(String id){
        return tNodeConfigInfoMapper.deleteByPrimaryKey(id);
    }
    @Override
    public List<TNodeConfigInfo> selectByExample(TNodeConfigInfoExample example){
        return tNodeConfigInfoMapper.selectByExample(example);
    }
    @Override
    public List<NodeInfoVo> selectAllNode(){
        return tNodeConfigInfoMapper.selectAllNode();
    }

    @Override
    public List<TNodeConfigInfo> selectAllNodeConfigInfo(@Param("params") Map params) {
        return tNodeConfigInfoMapper.selectAllNodeConfigInfo(params);
    }

    @Override
    public int updateAllNodeIsAvailabl(@Param("node") String node){
        int count = 0;
        try{
            JSONArray jsonArray = new  JSONArray(node);
            for(int i=0 ; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String id = jsonObj.getString("id");
                String isavailabl = jsonObj.getString("isavailabl");
                count += tNodeConfigInfoMapper.updateAllNodeIsAvailabl(id,isavailabl);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return count;
    }
}
