package com.hq.acdm.model.flight;



import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Getter
@Setter
public class FreeStandSum implements Serializable {

    private String stand;
    private String starttime;
    private String times;
    private String terminal;

    private String isRemote;
    private String airporttype;
    private String endtime;

    private static final long serialVersionUID = 1L;
}
