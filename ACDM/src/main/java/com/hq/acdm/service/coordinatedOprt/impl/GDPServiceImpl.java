package com.hq.acdm.service.coordinatedOprt.impl;

import com.hq.acdm.dao.coordinatedOprt.GDPMapper;
import com.hq.acdm.service.coordinatedOprt.GDPService;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.vo.coordinatedOprt.GDPPostponeCKVo;
import com.hq.acdm.vo.coordinatedOprt.GDPPostponeVo;
import com.hq.acdm.vo.coordinatedOprt.GDPVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2019/07/04 13:45
 * @Description
 */
@Service
public class GDPServiceImpl implements GDPService {
    @Resource
    private GDPMapper gDPMapper;
    @Override
    public List<GDPVo> findGDPChat() {
        return gDPMapper.getGDPChat();
    }

    @Override
    public int updatePostpone(String flightId, String optFlag,String content) {
        if (gDPMapper.getIsPostpone(flightId)>0){
             try {
               if (StringUtil.isNotEmpty(content)){
                   gDPMapper.insertSPECIAL(content);
               }
             }catch (Exception EX){
                 System.out.println("新增特殊事件报错"+EX);
             }

            return gDPMapper.updatePostpone(flightId,optFlag);
        }else{
            return gDPMapper.insertPostpone(flightId,optFlag);
        }
    }

    @Override
    public List<GDPPostponeVo> findQCJH() {
        List<GDPPostponeVo> list = gDPMapper.getQCJH();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setNUMBER(""+(i+1));
        }
        return list;
    }

    @Override
    public List<GDPPostponeVo> findQCYQF() {
        List<GDPPostponeVo> list = gDPMapper.getQCYQF();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setNUMBER(""+(i+1));
        }
        return list;
    }

    @Override
    public List<GDPPostponeCKVo> findZHZJ() {
        List<GDPPostponeCKVo> list = gDPMapper.getZHZJ();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setNUMBER(""+(i+1));
        }
        return list;
    }

    @Override
    public List<GDPPostponeCKVo> findHFZJ() {
        List<GDPPostponeCKVo> list = gDPMapper.getHFZJ();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setNUMBER(""+(i+1));
        }
        return list;
    }
}
