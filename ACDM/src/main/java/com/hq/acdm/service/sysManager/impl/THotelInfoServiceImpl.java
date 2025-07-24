package com.hq.acdm.service.sysManager.impl;

import com.hq.acdm.dao.realtimeSituation.THotelInfoMapper;
import com.hq.acdm.model.realtimeSituation.THotelInfo;
import com.hq.acdm.service.sysManager.THotelInfoService;
import com.hq.acdm.vo.sysManager.HotelInfoVo;
import net.sf.jxls.reader.XLSReadStatus;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReader;
import org.xml.sax.SAXException;

import javax.annotation.Resource;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class THotelInfoServiceImpl implements THotelInfoService {

    private final static String hotelXmlConfig = "/src/main/resources/template/hotelConfig.xml";

    @Resource
    private THotelInfoMapper tHotelInfoMapper;


    @Override
    public int insert(THotelInfo record) {
        return tHotelInfoMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(THotelInfo record) {
        return tHotelInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return tHotelInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<THotelInfo> selectAllTHotelInfo(@Param("params") Map params) {
        return tHotelInfoMapper.selectAllTHotelInfo(params);
    }

    @Override
    public List<HotelInfoVo> findImportHotelInfo(String filePath){

        XLSReader mainReader = null;

        try {
            InputStream inputXML = new BufferedInputStream(getClass().getClassLoader().getResourceAsStream(hotelXmlConfig));
            mainReader = ReaderBuilder.buildFromXML(inputXML);
            InputStream inputXLS = new BufferedInputStream(new FileInputStream(filePath));
            List<HotelInfoVo> hotelInfoList = new ArrayList<>();
            Map<String, Object> beans = new HashMap();
            beans.put("hotelInfoList", hotelInfoList);
            XLSReadStatus readStatus = mainReader.read(inputXLS, beans);
            return hotelInfoList;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

}
