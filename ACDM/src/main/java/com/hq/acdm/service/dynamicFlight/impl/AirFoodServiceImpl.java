package com.hq.acdm.service.dynamicFlight.impl;

import com.hq.acdm.dao.dynamicFlight.AirFoodMapper;
import com.hq.acdm.dao.dynamicFlight.FltMonitorMapper;
import com.hq.acdm.dao.realtimeSituation.TMultiDatasourceRecordMapper;
import com.hq.acdm.dao.realtimeSituation.TPresetFieldMapper;
import com.hq.acdm.model.realtimeSituation.TMultiDatasourceRecord;
import com.hq.acdm.model.realtimeSituation.TMultiDatasourceRecordExample;
import com.hq.acdm.model.realtimeSituation.TPresetField;
import com.hq.acdm.service.dynamicFlight.AirFoodService;
import com.hq.acdm.service.dynamicFlight.FltMonitorService;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.JexlUtil;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.vo.dynamicFlight.*;
import com.hq.acdm.vo.sysManager.HotelInfoVo;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.ReaderConfig;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.annotation.Resource;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class AirFoodServiceImpl implements AirFoodService{
    private final static String hotelXmlConfig = "/src/main/resources/template/csConfig.xml";
    @Resource
    private AirFoodMapper airFoodMapper;

    @Override
    public List<AirFoodFlightInfoVo> findAirFoodFltInfo(@Param("params") Map params) {
        List<AirFoodFlightInfoVo> list = new ArrayList<AirFoodFlightInfoVo>();
        List<AirFoodFlightInfoVo> listFltInfo = airFoodMapper.getAirFoodFltInfo(params);
        if(listFltInfo != null && listFltInfo.size()>0){
            for(int i=0;i<listFltInfo.size();i++){
                AirFoodFlightInfoVo vo = listFltInfo.get(i);

                vo.setSobt(DateTimeUtil.timeDayFormatByStr(vo.getSobt()));
                vo.setSibt(DateTimeUtil.timeDayFormatByStr(vo.getSibt()));
                vo.setEtot(DateTimeUtil.timeDayFormatByStr(vo.getEtot()));
                vo.setEtotA(DateTimeUtil.timeDayFormatByStr(vo.getEtotA()));
                vo.setAtot(DateTimeUtil.timeDayFormatByStr(vo.getAtot()));
                vo.setAtotA(DateTimeUtil.timeDayFormatByStr(vo.getAtotA()));
                vo.setEldt(DateTimeUtil.timeDayFormatByStr(vo.getEldt()));
                vo.setAldt(DateTimeUtil.timeDayFormatByStr(vo.getAldt()));
                vo.setAsc(DateTimeUtil.timeDayFormatByStr(vo.getAsc()));
                vo.setAec(DateTimeUtil.timeDayFormatByStr(vo.getAec()));

                list.add(vo);
            }
            return list;
        }else{
            return listFltInfo;
        }


    }


    @Override
    public List<AirPlanFoodVo> findImportAirPlanFood(InputStream in){

        XLSReader mainReader = null;

        try {
            InputStream inputXML = new BufferedInputStream(getClass().getClassLoader().getResourceAsStream(ResourceUtils.getFile("classpath:template").getAbsolutePath() + "/csConfig.xml"));

            mainReader = ReaderBuilder.buildFromXML(inputXML);
            InputStream inputXLS = new BufferedInputStream(in);
            List<AirPlanFoodVo> airPlanFoodList = new ArrayList<>();
            Map<String, Object> beans = new HashMap();
            beans.put("airPlanFoodList", airPlanFoodList);
            XLSReadStatus readStatus = mainReader.read(inputXLS, beans);
            return airPlanFoodList;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(AirPlanFoodVo record) {
        return airFoodMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insert(AirPlanFoodVo record) {
        return airFoodMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(String quarter,String username) {
        return airFoodMapper.deleteByPrimaryKey(quarter,username);
    }

    @Override
    public int addTaxiTimeVarBatch(List<AirPlanFoodVo> emps) {
        return airFoodMapper.addTaxiTimeVarBatch(emps);
    }
}
