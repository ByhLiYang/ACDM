package com.hq.acdm.service.sysManager;

import com.hq.acdm.model.realtimeSituation.THotelInfo;
import com.hq.acdm.model.realtimeSituation.THotelInfoExample;
import com.hq.acdm.vo.sysManager.HotelInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface THotelInfoService {

    public int insert(THotelInfo record);

    public int updateByPrimaryKeySelective(THotelInfo record);

    public int deleteByPrimaryKey(String id);

    public List<THotelInfo> selectAllTHotelInfo(@Param("params") Map params);

    public List<HotelInfoVo> findImportHotelInfo(String filePath);


}
