package com.hq.acdm.vo.dynamicFlight;

import lombok.Data;

@Data
public class LKVo {


    private int  zjLK;//旅客值机总数,安检总数,侯机总数,登机总数
    private String zjLKS;//旅客值机开始
    private String zjLKEND;//旅客值机结束
    private int  ajLK;//旅客安检数
    private String ajLKS;//旅客安检开始
    private String ajLKEND;//旅客安检结束
    private int   hj;//旅客侯机数
    private String hjS;//旅客侯机开始
    private String hjEND;//旅客侯机结束
    private int   dj;//旅客登机数
    private String djS;//旅客登机开始
    private String djEND;//旅客登机结束

    private int   hjVIP;//旅客侯机VIP数
    private int   hj2c;//旅客侯机2舱休息室数
}
