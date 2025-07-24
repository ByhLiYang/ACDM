package com.hq.acdm.vo.realtimeSituation;

import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2019/03/31 23:45
 * @Description
 */
@Data
public class FlightIndexVo {
    //正常数
    private int zCS;
    private int zCSA;
    private int zCSD;
    private int fHSA;
    private int fHSD;
    private int bJSA;
    private int bJSD;
    //延误数
    private int yWS;
    //晚到数
    private int yWSA;
    //放行
    private int fXYWS;
    private int qXS;
    private int qXSA;
    private int qXSD;
    private int eTA30;
    private int lDHX;
    private int dMBZ;
    private int zBJX;
    private int lGHX;
    private int kYJW;
//    已用机位
    private int yYJW;
    private double jWLYL;
    private double gMZDL;
    private double kQL;
    private int zHB;
    private int lK;
    private int xL;
    private double jGZXL;
    private double cGZXL;
}
