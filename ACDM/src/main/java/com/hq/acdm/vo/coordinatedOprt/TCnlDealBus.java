package com.hq.acdm.vo.coordinatedOprt;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TCnlDealBus {
    private String id;

    private String hotelId;

    private String carReg;

    private String busType;

    private String driver;

    private String phone;

    private String destination;

    private String acNumber;

    private String startTime;

    private String arrTime;

    private String staff;

    private String remk;

    private Date createTm;

    private Date updateTm;
    private String bstatus;

}