package com.hq.acdm.vo.coordinatedOprt;


import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class TCnlDeal  {
    private String id;

    private String cFlightId;

    private String cFlno;

    private String cExecDate;

    private String cSobt;

    private String cCnlTime;

    private String passangerCount;

    private String baggageCount;

    private String route;

    private String ttype;

    private String tstatus;

    private String status;
    private String remk;
    private Date createTm;

    private Date updateTm;
    private String fid;


 }