package com.hq.acdm.vo.coordinatedOprt;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2019/06/17 03:30
 * @Description
 */
@Data
public class TFlightSchedulingVo {

    private String exdt;
    private String hour;
    private int ccaACount;
    private int ccaDCount;
    private int ccaSUMCount;
    private double ccaxj;
    private List<TFlightScheduling> ccaAvos;
    private List<TFlightScheduling> ccaDvos;
    private List<TFlightScheduling> ccaSUMvos;
    private double ccaZX;
    private int csnACount;
    private int csnDCount;
    private int csnSUMCount;
    private double csnxj;
    private List<TFlightScheduling> csnAvos;
    private List<TFlightScheduling> csnDvos;
    private List<TFlightScheduling> csnSUMvos;
    private double csnZX;
    private int cesACount;
    private int cesDCount;
    private int cesSUMCount;
    private double cesxj;
    private List<TFlightScheduling> cesAvos;
    private List<TFlightScheduling> cesDvos;
    private List<TFlightScheduling> cesSUMvos;
    private double cesZX;
    private int igoACount;
    private int igoDCount;
    private int igoSUMCount;
    private double igoxj;
    private List<TFlightScheduling> igoAvos;
    private List<TFlightScheduling> igoDvos;
    private List<TFlightScheduling> igoSUMvos;
    private double igoZX;
    private int sum;
    private List<TFlightScheduling> sumvos;
    private double sumZX;
    private double xj;
    private String opt;
    private String downPercentage;
}
