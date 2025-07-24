package com.hq.acdm.service.Vedio.impl;

import com.hq.acdm.dao.Video.VideoMapper;
import com.hq.acdm.model.Video.Video;
import com.hq.acdm.service.Vedio.VideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 16:54
 */
@Service("VideoService")
public class VideoServiceImpl implements VideoService {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Resource
    private VideoMapper videoMapper;
    @Override
    public Map<String, Object> queryByCondition(Map<String, Object> map) {

        Map<String, Object> resultMap = new HashMap<>();
        List<Video> videoList = videoMapper.queryByCondition(map);
        if (videoList.size()>0){
            resultMap.put("accessUrl",videoList.get(0).getADDRESS());
            resultMap.put("profile","");
            resultMap.put("username","");
            resultMap.put("password","");
            resultMap.put("stream_transport_class","");
        }else{
            resultMap.put("error","没数据");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> queryHistory(Map<String, Object> map) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Video> videoList = videoMapper.queryByCondition(map);
        if (videoList.size()>0){
            if("".equals(videoList.get(0).getNVRADDRESS())||videoList.get(0).getNVRADDRESS()==null){
                resultMap.put("video_service_uuid",videoList.get(0).getADDRESS());
                resultMap.put("video_nvr_ip","");
                resultMap.put("playtime",map.get("playtime"));
                resultMap.put("videocode",map.get("videocode"));
            }else{
                resultMap.put("video_service_uuid",videoList.get(0).getADDRESS());
                resultMap.put("video_nvr_ip",videoList.get(0).getNVRADDRESS());
                resultMap.put("playtime",map.get("playtime"));
                resultMap.put("videocode",map.get("videocode"));
            }

        }else{
            resultMap.put("error","没数据");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> queryByStand(Map<String, Object> map) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Video> videoList = videoMapper.queryByStand(map);
        if (videoList.size()>0){
            if("".equals(videoList.get(0).getNVRADDRESS())||videoList.get(0).getNVRADDRESS()==null){
                resultMap.put("video_service_uuid",videoList.get(0).getADDRESS());
                resultMap.put("video_nvr_ip","");
                resultMap.put("playtime",map.get("playtime"));
                resultMap.put("videocode",videoList.get(0).getVIDEONO());
            }else{
                resultMap.put("video_service_uuid",videoList.get(0).getADDRESS());
                resultMap.put("video_nvr_ip",videoList.get(0).getNVRADDRESS());
                resultMap.put("playtime",map.get("playtime"));
                resultMap.put("videocode",videoList.get(0).getVIDEONO());
            }

        }else{
            resultMap.put("error","没数据");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> queryVideoHistoiy(Map<String, Object> map) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Video> videoList = videoMapper.queryByCondition(map);
        Date todayDate = new Date();

        if(videoList.size()>0){
            resultMap.put("video_service_uuid",videoList.get(0).getUUID());
            resultMap.put("video_nvr_ip",videoList.get(0).getNVRADDRESS());
            resultMap.put("playtime",simpleDateFormat.format(todayDate.getTime()-8*60*60*1000-60*1000));
        }
        return resultMap;
    }
}
