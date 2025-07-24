package com.hq.acdm.vo.realtimeSituation;

import lombok.Data;

import java.util.Date;

/**
 * @author LiFaQiang
 * @date 2019/04/15 01:31
 * @Description
 */
@Data
public class TIgoHotelStandardFeeVO {

    private String id;

    private String hotelName;

    private String hotelAddres;

    private String hotelTel;

    private String hotelManagerTel;

    private String nameOfPartyB;

    private String agreementStartDate;

    private String agreementEndDate;

    private Double bed;

    private Double homeBreakfast;

    private Double homeLunch;

    private Double homeDinner;

    private Double internationalBreakfast;

    private Double internationalLunch;

    private Double internationalDinner;

    private Double nightSnack;

    private String rmk;

    private String createTm;

    private String updateTm;

    private String createEmp;

    private String updateEmp;

}
