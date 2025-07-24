package com.hq.acdm.dao.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.GDPPostponeCKVo;
import com.hq.acdm.vo.coordinatedOprt.GDPPostponeVo;
import com.hq.acdm.vo.coordinatedOprt.GDPVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2019/07/04 11:40
 * @Description
 */
public interface GDPMapper {
    List<GDPVo> getGDPChat();
    int getIsPostpone(@Param("flightId") String flightId);
    int insertPostpone(@Param("flightId") String flightId,@Param("optFlag") String optFlag);
    int updatePostpone(@Param("flightId") String flightId,@Param("optFlag") String optFlag);
    List<GDPPostponeVo> getQCJH();
    List<GDPPostponeVo> getQCYQF();
    List<GDPPostponeCKVo> getZHZJ();
    List<GDPPostponeCKVo> getHFZJ();
    int insertSPECIAL(@Param("content") String content);
}
