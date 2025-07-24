package com.hq.acdm.service.supervision.impl;

import com.google.common.collect.Lists;
import com.hq.acdm.dao.index.VDelayFlightSumMapper;
import com.hq.acdm.dao.supervision.VAordcount1hourMapper;
import com.hq.acdm.dao.supervision.VFreestandSumMapper;
import com.hq.acdm.model.index.VDelayFlightSum;
import com.hq.acdm.model.supervision.managermonitor.VAordcount1hour;
import com.hq.acdm.model.supervision.managermonitor.VFreestandSum;
import com.hq.acdm.service.supervision.IManagerMonitorService;
import com.hq.acdm.vo.supervision.managermonitor.DateName;
import com.hq.acdm.vo.supervision.managermonitor.FourD;
import com.hq.acdm.vo.supervision.managermonitor.OutBoundDelayVo;
import com.hq.acdm.vo.supervision.managermonitor.ParkingSpaceVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/9/17 0017
 * @Description:
 */
@Service("managerMonitorService")
public class ManagerMonitorServiceImpl implements IManagerMonitorService {

    @Resource
    private VFreestandSumMapper vFreestandSumMapper;
    @Resource
    private VAordcount1hourMapper vAordcount1hourMapper;
    @Resource
    private VDelayFlightSumMapper vDelayFlightSumMapper;

    @Override
    public OutBoundDelayVo getOne() {
        OutBoundDelayVo delayVo = new OutBoundDelayVo();
        //出港延误列表
        List<FourD> fourDList = Lists.newArrayList();
        FourD fourD = new FourD();
        fourD.setD0("时间（分钟）");
        fourD.setD1("已执行航班");
        fourD.setD2("未执行航班");
        fourD.setD3("滞留旅客");
        fourDList.add(fourD);
        List<VDelayFlightSum> executedList = vDelayFlightSumMapper.getRecord();
        //未执行=flightNum-delayFlightNum（已经执行）
        for (VDelayFlightSum flight : executedList) {
            FourD four = new FourD();
            four.setD0(flight.getType());
            four.setD1(String.valueOf(flight.getDelayFlightNum()));
            four.setD2(String.valueOf(flight.getFlightNum().subtract(flight.getDelayFlightNum())));
            four.setD3(String.valueOf(flight.getPassengerNum()));
            fourDList.add(four);
        }
        delayVo.setTableData1(fourDList);

        //出港延误总数
        Integer delayTotal = vDelayFlightSumMapper.getDelayTotal();
        delayVo.setDelayNum(String.valueOf(delayTotal));

        //当日跑道方向
        FourD date = vDelayFlightSumMapper.getDateName();
        if (null != date) {
            List<DateName> tableData2 = Lists.newArrayList();

            DateName dateNameOne = new DateName();
            dateNameOne.setDate("当日起飞跑道");
            dateNameOne.setName(date.getD1());

            DateName dateNameTwo = new DateName();
            dateNameTwo.setDate("当日降落跑道");
            dateNameTwo.setName(date.getD0());

            tableData2.add(dateNameOne);
            tableData2.add(dateNameTwo);

            delayVo.setTableData2(tableData2);
        }



        return delayVo;
    }

    @Override
    public ParkingSpaceVo getTwo() {
        ParkingSpaceVo spaceVo = new ParkingSpaceVo();
        //机场空闲停机位
        String[] list = {"B","C","D","E"};
        List<String> bcdeList = Arrays.asList(list);

        List<VFreestandSum> freeList = vFreestandSumMapper.getAll();

        List<FourD> fourDList = Lists.newArrayList();
        FourD fourDFirst = new FourD();
        fourDFirst.setD0("");
        fourDFirst.setD1("T1航站楼");
        fourDFirst.setD2("T2航站楼");
        fourDFirst.setD3("合计");
//        fourDList.add(fourDFirst);

        for (String str : bcdeList) {
            FourD fourD = new FourD();
            for (VFreestandSum free : freeList) {
                if (str.equals(free.getDescription())) {
                    fourD.setD0(str);
                    if (free.getTerminal().equals("1")) {
                        fourD.setD1(String.valueOf(free.getStands()));
                    }
                    if (free.getTerminal().equals("2")) {
                        fourD.setD2(String.valueOf(free.getStands()));
                    }
                }
                fourD.setD3(fourD.getMyD3());
            }
            fourDList.add(fourD);
        }
        spaceVo.setTableData2(fourDList);

        //空闲停机位总数
        spaceVo.setSlots(String.valueOf(vFreestandSumMapper.getFreeTotal()));

        //本小时和未来一小时起降航班数量
        List<VAordcount1hour> hourList = vAordcount1hourMapper.get();
        if (null != hourList && hourList.size()>0) {
            VAordcount1hour hour = hourList.get(0);

            List<FourD> fourDListTable1 = Lists.newArrayList();
            FourD fourDFirstTable1 = new FourD();
            fourDFirstTable1.setD0("");
            fourDFirstTable1.setD1("当前一小时");
            fourDFirstTable1.setD2("未来一小时");
            fourDFirstTable1.setD3("合计");
//            fourDListTable1.add(fourDFirstTable1);

            for (int i = 0;i < 2;i++) {
                FourD fourD = new FourD();
                if (i == 0) {
                    fourD.setD0("起飞数量");
                    fourD.setD1(String.valueOf(hour.getDcountthish()));
                    fourD.setD2(String.valueOf(hour.getDcountnexth()));
                    fourD.setD3(String.valueOf(hour.getDcount()));
                } else {
                    fourD.setD0("降落数量");
                    fourD.setD1(String.valueOf(hour.getAcountthish()));
                    fourD.setD2(String.valueOf(hour.getAcountnexth()));
                    fourD.setD3(String.valueOf(hour.getAcount()));
                }
                fourDListTable1.add(fourD);
            }
            spaceVo.setTableData1(fourDListTable1);
        }
        return spaceVo;
    }
}
