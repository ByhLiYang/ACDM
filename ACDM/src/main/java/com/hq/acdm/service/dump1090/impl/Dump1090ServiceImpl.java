package com.hq.acdm.service.dump1090.impl;

import com.hq.acdm.controller.req.AircraftSaveReq;
import com.hq.acdm.dao.dump1090.Dump1090Mapper;
import com.hq.acdm.model.dump1090.Aircraft;
import com.hq.acdm.service.dump1090.Dump1090Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class Dump1090ServiceImpl  implements Dump1090Service {
    @Resource
    private Dump1090Mapper dump1090Mapper;

    @Override
    public void dataReception(List<AircraftSaveReq> aircraftSaveReqList) {
        log.info("------------Dump1090Controller dataReception.json Start-----------------");
        aircraftListUpdateOrSave(aircraftSaveReqList);
        log.info("------------Dump1090Controller dataReception.json End---------------");
    }


    private void aircraftListUpdateOrSave(List<AircraftSaveReq> aircraftSaveReqList)  {
        if (aircraftSaveReqList == null || aircraftSaveReqList.isEmpty()) {
            return ;
        }

        for (AircraftSaveReq aircraftSaveReq : aircraftSaveReqList) {
            if (dump1090Mapper.checkAircraftExists(aircraftSaveReq.getHex())){
                dump1090Mapper.updateByHex(aircraftSaveReq);
            }else {
                dump1090Mapper.save(convertToAircraft(aircraftSaveReq));
            }
        }
    }

    private Aircraft convertToAircraft(AircraftSaveReq aircraftSaveReq) {
        Aircraft aircraft = new Aircraft();
        aircraft.setId(UUID.randomUUID().toString().replace("-",""));
        aircraft.setHex(aircraftSaveReq.getHex());
        aircraft.setFlight(aircraftSaveReq.getFlight());
        aircraft.setLat(aircraftSaveReq.getLat());
        aircraft.setLon(aircraftSaveReq.getLon());
        aircraft.setSpeed(aircraftSaveReq.getSpeed());
        aircraft.setAltitude(aircraftSaveReq.getAltitude());
        aircraft.setTrack(aircraftSaveReq.getTrack());
//        aircraft.setCreateTm(new Date());
//        aircraft.setUpdateTm(new Date());
        return aircraft;
    }




}
