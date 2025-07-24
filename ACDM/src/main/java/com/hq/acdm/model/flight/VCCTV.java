package com.hq.acdm.model.flight;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class VCCTV implements Serializable {
    private String matched_Fno;

    private String stand;

    private String matched_Flight_Opdate;

    private String mile_Date;

    private String milestone_Datetime;

    private String direction;

    private String ags;

    private String sdt;

    private String edt;

    private String cobt;

    private String alt;

    private String ato;

    private String milestoneId;

    private String dsCode;

    private Date sentDatetime;

    private String vedioLocation;

    private String pictureLocation;

    private String comments;

    private Date correctedMilestoneDatetime;

    private Short confirmYn;

    private Short matchedYn;

    private String matchedFlightRepeatno;

    private String isIgnore;

    private Date operationalDate;

}