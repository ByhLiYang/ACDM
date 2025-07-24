package com.hq.acdm.controller.sysManager;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.realtimeSituation.THotelInfo;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.dynamicFlight.FltMonitorService;
import com.hq.acdm.service.sysManager.THotelInfoService;

import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.vo.sysManager.HotelInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/25 11:23
 * @Description
 */
@Api(description = "酒店信息表维护")
@RestController
@RequestMapping("/sysManager/tHotelInfo")
public class THotelInfoController {

    @Resource
    private THotelInfoService tHotelInfoService;

    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private FltMonitorService fltMonitorService;

    @ApiOperation(httpMethod = "POST", value = "查询全部酒店信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectAllTHotelInfo.json", method = RequestMethod.POST)
    public ServerResponse selectAllTHotelInfo(@ApiParam("查询全部酒店信息")
                                                  @RequestParam("hotelAddres") String hotelAddres,
                                                  @RequestParam("hotelName") String hotelName,
                                                  HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> queryMap = new HashMap<String,Object>();
        queryMap.put("hotelAddres",hotelAddres);
        queryMap.put("hotelName",hotelName);
        List<THotelInfo> tHotelInfoList = tHotelInfoService.selectAllTHotelInfo(queryMap);
        return ServerResponse.createBySuccess(tHotelInfoList);
    }

    @ApiOperation(httpMethod = "POST", value = "酒店信息新增", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    public ServerResponse insert(@ApiParam("酒店信息新增")
                                 @RequestParam("hotelName") String hotelName,
                                 @RequestParam("hotelAddres") String hotelAddres,
                                 @RequestParam("hotelTel") String hotelTel,
                                 @RequestParam("hotelRoomType") String hotelRoomType,
                                 @RequestParam("hotelRoomNum") String hotelRoomNum,
                                 @RequestParam("hotelPrice") String hotelPrice,
                                 @RequestParam("hotelPeopleNum") String hotelPeopleNum,
                                 HttpServletRequest request, HttpServletResponse response) {
        THotelInfo tHotelInfo = new THotelInfo();
        tHotelInfo.setId(UUID.randomUUID().toString().replaceAll("-",""));
        tHotelInfo.setHotelName(hotelName);
        tHotelInfo.setHotelAddres(hotelAddres);
        tHotelInfo.setHotelTel(hotelTel);
        tHotelInfo.setHotelRoomType(hotelRoomType);
        long hotelRoomNumLong = 0;
        if(hotelRoomNum != null && !"".equals(hotelRoomNum)){
            hotelRoomNumLong = Long.parseLong(hotelRoomNum);
        }
        tHotelInfo.setHotelRoomNum(hotelRoomNumLong);
        long hotelPriceLong = 0;
        if(hotelPrice != null && !"".equals(hotelPrice)){
            hotelPriceLong = Long.parseLong(hotelPrice);
        }
        tHotelInfo.setHotelPrice(hotelPriceLong);
        long hotelPeopleNumLong = 0;
        if(hotelPeopleNum != null && !"".equals(hotelPeopleNum)){
            hotelPeopleNumLong = Long.parseLong(hotelPeopleNum);
        }
        tHotelInfo.setHotelPeopleNum(hotelPeopleNumLong);
        Users sysUser =null;
        try {
            String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
            String cacheValue = sysCacheService.getFromCache(loginToken);
            sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
            });
        }catch (Exception ex){}

        String createUsr = "";
        if (null!=sysUser){
            createUsr=sysUser.getUserId();
        }
        tHotelInfo.setCreateEmp(createUsr);
        tHotelInfo.setCreateTm(new Date());
        return ServerResponse.createBySuccess(tHotelInfoService.insert(tHotelInfo));
    }

    @ApiOperation(httpMethod = "POST", value = "酒店信息更新", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateByPrimaryKey.json", method = RequestMethod.POST)
    public ServerResponse updateByPrimaryKey(@ApiParam("酒店信息更新")
                                             @RequestParam("id") String id,
                                             @RequestParam("hotelName") String hotelName,
                                             @RequestParam("hotelAddres") String hotelAddres,
                                             @RequestParam("hotelTel") String hotelTel,
                                             @RequestParam("hotelRoomType") String hotelRoomType,
                                             @RequestParam("hotelRoomNum") String hotelRoomNum,
                                             @RequestParam("hotelPrice") String hotelPrice,
                                             @RequestParam("hotelPeopleNum") String hotelPeopleNum,
                                 HttpServletRequest request, HttpServletResponse response) {
        THotelInfo tHotelInfo = new THotelInfo();
        tHotelInfo.setId(id);
        tHotelInfo.setHotelName(hotelName);
        tHotelInfo.setHotelAddres(hotelAddres);
        tHotelInfo.setHotelTel(hotelTel);
        tHotelInfo.setHotelRoomType(hotelRoomType);
        long hotelRoomNumLong = 0;
        if(hotelRoomNum != null && !"".equals(hotelRoomNum)){
            hotelRoomNumLong = Long.parseLong(hotelRoomNum);
        }
        tHotelInfo.setHotelRoomNum(hotelRoomNumLong);
        long hotelPriceLong = 0;
        if(hotelPrice != null && !"".equals(hotelPrice)){
            hotelPriceLong = Long.parseLong(hotelPrice);
        }
        tHotelInfo.setHotelPrice(hotelPriceLong);
        long hotelPeopleNumLong = 0;
        if(hotelPeopleNum != null && !"".equals(hotelPeopleNum)){
            hotelPeopleNumLong = Long.parseLong(hotelPeopleNum);
        }
        tHotelInfo.setHotelPeopleNum(hotelPeopleNumLong);
        Users sysUser =null;
        try {
            String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
            String cacheValue = sysCacheService.getFromCache(loginToken);
            sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
            });
        }catch (Exception ex){}

        String createUsr = "";
        if (null!=sysUser){
            createUsr=sysUser.getUserId();
        }
        tHotelInfo.setUpdateEmp(createUsr);
        tHotelInfo.setUpdateTm(new Date());
        return ServerResponse.createBySuccess(tHotelInfoService.updateByPrimaryKeySelective(tHotelInfo));
    }

    @ApiOperation(httpMethod = "POST", value = "酒店信息删除", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteByPrimaryKey.json", method = RequestMethod.POST)
    public ServerResponse deleteByPrimaryKey(@ApiParam("酒店信息删除")
                                             @RequestParam("id") String id,
                                             HttpServletRequest request, HttpServletResponse response) {
        Users sysUser =null;
        try {
            String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
            String cacheValue = sysCacheService.getFromCache(loginToken);
            sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
            });
            String createUsr = "";
            if (null!=sysUser){
                createUsr=sysUser.getUserId();
            }
            Map<String, Object> queryMap = new HashMap<>();
            queryMap.put("flightId",1);
            queryMap.put("nodeColumn","RMK");
            queryMap.put("value","酒店信息删除");
            queryMap.put("source",id);
            queryMap.put("username",createUsr);
            queryMap.put("filed","RMK");
            fltMonitorService.insertTlocalForprivate(queryMap);
        }catch (Exception ex){}


        return ServerResponse.createBySuccess(tHotelInfoService.deleteByPrimaryKey(id));
    }


    @ApiOperation(httpMethod = "POST", value = "酒店信息导入", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/importHotelInfo.json", method = RequestMethod.POST)
    public ServerResponse importHotelInfo(@ApiParam("酒店信息导入")
                                              @RequestParam(value="file", required=false) MultipartFile file,
                                             //@RequestPart(value="file", required=false) MultipartFile file,
                                             HttpServletRequest request, HttpServletResponse response) {
        String msg = "";
        String templateFile = request.getSession().getServletContext().getRealPath("/src/main/resources/template");
        try {
            if (null == file) {
                msg = "导入文件为空!!";
            } else {
                String fileName = file.getOriginalFilename();
                if (!fileName.endsWith(".xls") && !fileName.endsWith(".xlsx") && !fileName.endsWith(".xlsm")) {
                    msg = "文件类型错误，导入文件仅允许excel文件类型!!";
                }else{
                    File newFile = new File(templateFile);
                    if (!newFile.exists()) {
                        newFile.mkdirs();
                    }

                    InputStream in = file.getInputStream();
                    FileOutputStream os = new FileOutputStream(newFile);
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    //读取到缓冲区
                    while((bytesRead = in.read(buffer)) != -1){
                        os.write(buffer, 0, bytesRead);
                    }
                    in.close();
                    //刷新OutputStream，将缓冲的数据写入文件
                    os.flush();
                    os.close();

                    String resultFilePath = templateFile + File.separator + fileName;

                    List<HotelInfoVo> voList = tHotelInfoService.findImportHotelInfo(resultFilePath);
                    if(voList != null && voList.size()>0){
                        for(int i=0;i<voList.size();i++){
                            HotelInfoVo vo = voList.get(i);
                            THotelInfo tHotelInfo = new THotelInfo();
                            tHotelInfo.setId(UUID.randomUUID().toString().replaceAll("-",""));
                            tHotelInfo.setHotelName(vo.getHotelName());
                            tHotelInfo.setHotelAddres(vo.getHotelAddres());
                            tHotelInfo.setHotelTel(vo.getHotelTel());
                            tHotelInfo.setHotelRoomType(vo.getHotelRoomType());
                            long hotelRoomNumLong = 0;
                            if(vo.getHotelRoomNum() != null && !"".equals(vo.getHotelRoomNum())){
                                hotelRoomNumLong = Long.parseLong(vo.getHotelRoomNum());
                            }
                            tHotelInfo.setHotelRoomNum(hotelRoomNumLong);
                            long hotelPriceLong = 0;
                            if(vo.getHotelPrice() != null && !"".equals(vo.getHotelPrice())){
                                hotelPriceLong = Long.parseLong(vo.getHotelPrice());
                            }
                            tHotelInfo.setHotelPrice(hotelPriceLong);
                            long hotelPeopleNumLong = 0;
                            if(vo.getHotelPeopleNum() != null && !"".equals(vo.getHotelPeopleNum())){
                                hotelPeopleNumLong = Long.parseLong(vo.getHotelPeopleNum());
                            }
                            tHotelInfo.setHotelPeopleNum(hotelPeopleNumLong);
                            tHotelInfo.setCreateEmp("Admin");
                            tHotelInfo.setCreateTm(new Date());
                            tHotelInfoService.insert(tHotelInfo);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            msg = "系统读写文件错误，请稍后再试!!";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "系统正忙，请稍后再试!!";
        }
        return ServerResponse.createBySuccess(msg);
    }





}
