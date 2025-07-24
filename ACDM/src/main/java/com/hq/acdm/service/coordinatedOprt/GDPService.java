package com.hq.acdm.service.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.GDPPostponeCKVo;
import com.hq.acdm.vo.coordinatedOprt.GDPPostponeVo;
import com.hq.acdm.vo.coordinatedOprt.GDPVo;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2019/07/04 13:42
 * @Description
 */
public interface GDPService {
    List<GDPVo> findGDPChat();
    int updatePostpone(String flightId,String optFlag,String content);
    List<GDPPostponeVo> findQCJH();
    List<GDPPostponeVo> findQCYQF();
    List<GDPPostponeCKVo> findZHZJ();
    List<GDPPostponeCKVo> findHFZJ();
}
