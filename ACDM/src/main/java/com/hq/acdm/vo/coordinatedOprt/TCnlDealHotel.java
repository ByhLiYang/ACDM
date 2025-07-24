package com.hq.acdm.vo.coordinatedOprt;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TCnlDealHotel{
    private String id;

    private String dealId;

    private String hotelsName;

    private String hotelType;

    private String hotelAddress;

    private String hotelPhone;

    private String esBusnum;

    private String esNumber;

    private String breakfasts;

    private String lunch;

    private String dinner;

    private String snack;

    private String staff;

    private String remk;

    private Date createTm;

    private Date updateTm;

    private String drinks;

    private String breakfastsnum;
    private String lunchnum;
    private String dinnernum;
    private String snacknum;
    private String drinksnum;


}