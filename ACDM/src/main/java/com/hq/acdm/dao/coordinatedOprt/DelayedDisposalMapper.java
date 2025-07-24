package com.hq.acdm.dao.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/06/12 11:28
 * @Description
 */
public interface DelayedDisposalMapper {
    //查询取消航班
    List<DelayedDisposalVo> findCnlInfo(@Param("params") Map params);
    List<DelayedDisposalVo> findCnlInfoNo(@Param("params") Map params);
    //智航查询取消航班
    List<DelayedDisposalVo> findCnlInfoByZH(@Param("params") Map params);
    //查询取消酒店
    List<DelayedDisposalVo> findholInfo(@Param("params") Map params);
    //删除酒店
    int deleteHolByPrimaryKey(@Param("id") String id);
    //根据外键删除酒店
    int deleteHolByDealIdKey(@Param("dealId") String dealId);
    //新增酒店
    int insertHolSelective(TCnlDealHotel record);
    //修改酒店
    int updateHolByPrimaryKeySelective(TCnlDealHotel record);
    //删除巴士
    int deleteBusByPrimaryKey(String id);
    //根据外键删除巴士
    int deleteBusByHotelIdKey(@Param("hotelId") String hotelId);
    //新增巴士
    int insertBusSelective(TCnlDealBus record);
    //修改巴士
    int updateBusByPrimaryKeySelective(TCnlDealBus record);
    //删除航班
    int deleteDealByPrimaryKey(String id);
    //新增航班
    int insertDealSelective(TCnlDeal record);
    //修改航班
    int updateDealByPrimaryKeySelective(TCnlDeal record);
    //根据条件查询取消航班
    TCnlDeal findTCnlDealInfo(@Param("params") Map params);

    //根据条件查询有没有补航班
    TCnlDeal findFCnlDealInfo(@Param("params") Map params);
    //根据id查询巴士
    TCnlDealBus selectByPrimaryKey(String id);
}
