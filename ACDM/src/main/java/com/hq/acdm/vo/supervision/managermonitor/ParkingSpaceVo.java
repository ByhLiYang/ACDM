package com.hq.acdm.vo.supervision.managermonitor;

import lombok.Data;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/9/17 0017
 * @Description:
 */
@Data
public class ParkingSpaceVo {
    /**
     * 本小时和未来一小时起降航班数量
     */
    private List<FourD> tableData1;

    /**
     * 机场空闲停机位
     */
    private List<FourD> tableData2;

    /**
     * 机场空闲停机位总数
     */
    private String slots;

}
