package com.hq.acdm.service.coordinatedOprt.impl;

import com.hq.acdm.dao.coordinatedOprt.DelayedDisposalMapper;
import com.hq.acdm.dao.coordinatedOprt.FlightCutsMapper;
import com.hq.acdm.service.coordinatedOprt.DelayedDisposalService;
import com.hq.acdm.service.coordinatedOprt.FlightCutsService;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.vo.coordinatedOprt.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/06/12 14:23
 * @Description
 */
@Service
public class DelayedDisposalServiceImpl implements DelayedDisposalService {
    @Resource
    private DelayedDisposalMapper delayedDisposalMapper;

    @Override
    public List<DelayedDisposalVo> findCnlInfo(Map params) {
        List<DelayedDisposalVo> list=delayedDisposalMapper.findCnlInfo(params);
        DelayedDisposalVo vo=new DelayedDisposalVo();
        List<DelayedDisposalVo> listS=new ArrayList<DelayedDisposalVo>();
        int a=0;
        for (int i = 0; i <list.size() ; i++) {
            vo=list.get(i);
/*            if (vo.getBaggageCount()==null)vo.setBaggageCount("");
            if (vo.getId()==null)vo.setId("");
            if (vo.getCdat()==null)vo.setCdat("");
            if (vo.getCExecDate()==null)vo.setCExecDate("");
            if (vo.getCFlightId()==null)vo.setCFlightId("");
            if (vo.getCSobt()==null)vo.setCSobt("");
            if (vo.getLstu()==null)vo.setLstu("");
            if (vo.getPassangerCount()==null)vo.setPassangerCount("");
            if (vo.getSExecDate()==null)vo.setSExecDate("");
            if (vo.getSFlightId()==null)vo.setSFlightId("");
            if (vo.getSFlno()==null)vo.setSFlno("");
            if (vo.getSSobt()==null)vo.setSSobt("");
            if (vo.getStatus()==null)vo.setStatus("0");*/
            listS.add(vo);

        }
        return listS;
    }

    @Override
    public List<DelayedDisposalVo> findCnlInfoNo(Map params) {
        List<DelayedDisposalVo> list=delayedDisposalMapper.findCnlInfoNo(params);
        DelayedDisposalVo vo=new DelayedDisposalVo();
        List<DelayedDisposalVo> listS=new ArrayList<DelayedDisposalVo>();
        int a=0;
        for (int i = 0; i <list.size() ; i++) {
            vo=list.get(i);
/*            if (vo.getBaggageCount()==null)vo.setBaggageCount("");
            if (vo.getId()==null)vo.setId("");
            if (vo.getCdat()==null)vo.setCdat("");
            if (vo.getCExecDate()==null)vo.setCExecDate("");
            if (vo.getCFlightId()==null)vo.setCFlightId("");
            if (vo.getCSobt()==null)vo.setCSobt("");
            if (vo.getLstu()==null)vo.setLstu("");
            if (vo.getPassangerCount()==null)vo.setPassangerCount("");
            if (vo.getSExecDate()==null)vo.setSExecDate("");
            if (vo.getSFlightId()==null)vo.setSFlightId("");
            if (vo.getSFlno()==null)vo.setSFlno("");
            if (vo.getSSobt()==null)vo.setSSobt("");
            if (vo.getStatus()==null)vo.setStatus("0");*/
            listS.add(vo);

        }
        return listS;
    }

    @Override
    public List<DelayedDisposalVo> findCnlInfoByZH(Map params) {
        return delayedDisposalMapper.findCnlInfoByZH(params);
    }

    @Override
    public Map<String, Object> findholInfo(Map params) {
        Map<String, Object> map=new HashMap<String, Object>();

        List<Map<String, Object>> holmaplist=new ArrayList<Map<String, Object>>();
        List<DelayedDisposalVo> list=delayedDisposalMapper.findholInfo(params);
        for (int i = 0; i <list.size() ; i++) {
            if (i==0){
                map.put("id",list.get(i).getId());
                map.put("cFlno",list.get(i).getCFlno());
                map.put("cSobt",list.get(i).getCSobt());
                map.put("tstatus",list.get(i).getTstatus());
                map.put("ttype",list.get(i).getTtype());
                map.put("route",list.get(i).getRoute());
                map.put("remk",list.get(i).getRemk());
            }
            if (StringUtil.isNotEmpty(list.get(i).getHid())){
                Map<String, Object> holmap=new HashMap<String, Object>();
                holmap.put("id",list.get(i).getId());
                holmap.put("hid",list.get(i).getHid());
                holmap.put("hotelType",list.get(i).getHotelType());
                holmap.put("esNumber",list.get(i).getEsNumber());
                holmap.put("esBusnum",list.get(i).getEsBusnum());
                holmap.put("hotelsName",list.get(i).getHotelsName());

                holmap.put("breakfasts",list.get(i).getBreakfasts());
                holmap.put("lunch",list.get(i).getLunch());
                holmap.put("dinner",list.get(i).getDinner());
                holmap.put("snack",list.get(i).getSnack());

                holmap.put("drinks",list.get(i).getDrinks());
                holmap.put("breakfastsnum",list.get(i).getBreakfastsnum());
                holmap.put("lunchnum",list.get(i).getLunchnum());
                holmap.put("dinnernum",list.get(i).getDinnernum());
                holmap.put("snacknum",list.get(i).getSnacknum());
                holmap.put("drinksnum",list.get(i).getDrinksnum());


                holmap.put("isAdd","U");
                holmaplist.add(holmap);
            }

        }
        map.put("hollist",holmaplist);
        return map;
    }

    @Override
    public Map<String, Object> findbusInfo(Map params) {
        Map<String, Object> map=new HashMap<String, Object>();

        List<Map<String, Object>> busmaplist=new ArrayList<Map<String, Object>>();
        List<DelayedDisposalVo> list=delayedDisposalMapper.findCnlInfo(params);
        for (int i = 0; i <list.size() ; i++) {
            if (i==0){
                map.put("id",list.get(i).getId());
                map.put("cFlno",list.get(i).getCFlno());
                map.put("cSobt",list.get(i).getCSobt());
                map.put("tstatus",list.get(i).getTstatus());
                map.put("ttype",list.get(i).getTtype());
                map.put("route",list.get(i).getRoute());
                map.put("remk",list.get(i).getRemk());
            }
            if (StringUtil.isNotEmpty(list.get(i).getBid())){
                Map<String, Object> busmap=new HashMap<String, Object>();
                busmap.put("bid",list.get(i).getBid());
                busmap.put("hid",list.get(i).getHid());
                busmap.put("hotelType",list.get(i).getHotelType());
                busmap.put("hotelsName",list.get(i).getHotelsName());
                busmap.put("carReg",list.get(i).getCarReg());
                busmap.put("driver",list.get(i).getDriver());
                busmap.put("phone",list.get(i).getPhone());
                busmap.put("acNumber",list.get(i).getAcNumber());
                busmap.put("startTime",list.get(i).getStartTime());
                busmap.put("staff",list.get(i).getStaff());
                busmap.put("bstatus",list.get(i).getBstatus());
                busmap.put("isAdd","U");

                busmaplist.add(busmap);
            }

        }
        map.put("buslist",busmaplist);
        return map;
    }

    @Override
    public TCnlDeal findTCnlDealInfo(Map params) {
        return delayedDisposalMapper.findTCnlDealInfo(params);
    }

    @Override
    public TCnlDeal findFCnlDealInfo(Map params) {
        return delayedDisposalMapper.findFCnlDealInfo(params);
    }

    @Override
    public TCnlDealBus selectByPrimaryKey(String id) {
        return delayedDisposalMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteHolByPrimaryKey(String id) {
        return delayedDisposalMapper.deleteHolByPrimaryKey(id);
    }

    @Override
    public int deleteHolByDealIdKey(String dealId) {
        return delayedDisposalMapper.deleteHolByDealIdKey(dealId);
    }

    @Override
    public int insertHolSelective(TCnlDealHotel record) {
        return delayedDisposalMapper.insertHolSelective(record);
    }

    @Override
    public int updateHolByPrimaryKeySelective(TCnlDealHotel record) {
        return delayedDisposalMapper.updateHolByPrimaryKeySelective(record);
    }

    @Override
    public int deleteBusByPrimaryKey(String id) {
        return delayedDisposalMapper.deleteBusByPrimaryKey(id);
    }

    @Override
    public int deleteBusByHotelIdKey(String hotelId) {
        return delayedDisposalMapper.deleteBusByHotelIdKey(hotelId);
    }

    @Override
    public int insertBusSelective(TCnlDealBus record) {
        return delayedDisposalMapper.insertBusSelective(record);
    }

    @Override
    public int updateBusByPrimaryKeySelective(TCnlDealBus record) {
        return delayedDisposalMapper.updateBusByPrimaryKeySelective(record);
    }

    @Override
    public int deleteDealByPrimaryKey(String id) {
        return delayedDisposalMapper.deleteDealByPrimaryKey(id);
    }

    @Override
    public int insertDealSelective(TCnlDeal record) {
        return delayedDisposalMapper.insertDealSelective(record);
    }

    @Override
    public int updateDealByPrimaryKeySelective(TCnlDeal record) {
        return delayedDisposalMapper.updateDealByPrimaryKeySelective(record);
    }


}
