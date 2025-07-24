package com.hq.acdm.model.statistics.flightQuery;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangshuhao
 * @date 2018/10/19 0019 13:08
 */
@Getter
@Setter
public class MudidiAirport {
    //--------NXD---------------------------------------------------------------------
    /**
     * A470:福州、厦门、深圳     汕头、晋江、珠海、澳门、香港
     *     FOC    XMN  SZX  SWA   JJN  ZUH   MFM   HKG
     */
    String A470="FOC,XMN,SZX,SWA,JJN,ZUH,MFM,HKG,ZUH,TPE,TSA,RMQ,YIW";


    /**
     * A599:广州、三亚、深圳   珠海、武夷山、北海、湛江          0604日加海口
     *     CAN   SYX   SZX  ZUH   WUS    BHY   ZHA          HAK
     */
    String A599="CAN,SYX,SZX,ZUH,WUS,BHY,ZHA,HAK,KOW,LCX,JUZ,JGS,WUZ,BAR";

    /**
     * H24:昆明、南昌、贵阳、桂林、长沙     0604日加南宁、
     *      KMG   KHN  KWE  KWL   CSX   NNG
     */
    String H24="KMG,KHN,KWE,KWL,CSX,NNG,HHA,YBP,LZH,BFJ,YIC,LJG,TXN,JDZ,DLU,LUM,AVA,DIG,JHG,LZO,TCZ,ACX,HJJ,HNY,KJH,JIU,HZH,SYM";

    /**
     * H26:黄山、景德镇
     *    TXN   JDZ
     */
    String H26="TXN,JDZ";

    String otherNXD = "WNH";
    //-----------AND------------------------------------------------------------------
    /**
     * G204：宁波、杭州、黄岩、温州
     *      NGB   HGH   HYN   WNZ
     */
    String G204="NGB,HGH,HYN,WNZ";
    //-----------PIKAS------------------------------------------------------------------
    /**
     * A593：北京、天津、济南、石家庄、连云港、济宁、东营、       临沂
     *    PEK  NAY  TSN  TNA  SJW    LYG  JNG     DOY DGY   LYI
     */
    String A593="PEK,NAY,TSN,TNA,SJW,LYG,JNG,DOY,DGY,LYI,SHE,XUZ,TAO,YNT,WEH,WEF,YNZ,UCB,YNJ,CGQ,HLD,MDG,DLC,ZQZ,NDG,HDG,HIA,NBS,DDG,JNZ,YKH,HRB,RIZ";

    /**
     * R343武汉区域：成都、重庆、张家界、绵阳、宜昌、常德、兴义、宜宾、南充
     *             CTU    CKG  DYG     MIG   YIH   CGD  ACX   YBP  NAO
     */
    String R343="CTU,CKG,DYG,MIG,YIH,CGD,ACX,YBP,NAO,CZX,WXN,AQG,ZYI,WMT,JUH,TEN,WUH,DAX,SHS,JIQ,XIC,LPF,ENH,LXA";
    /**
     * R208郑州区域：洛阳、太原、运城、大同、兰州、敦煌、西安、乌鲁木齐 、呼和浩特、包头、西宁、银川、邯郸、九寨沟
     LYA    TYN  YCU    DAT  LHW   DNH  XIY    URC      HET      BAV  XNN  INC    HDG    JZH

     */
    String B208="LYA,TYN,YCU,DAT,LHW,DNH,XIY,URC,HET,BAV,XNN,INC,HDG,JZH,CGO,ZGC," +
            "WUA,HLD,HLH,KHG,HTN,UYN,JGN,FUG,CIH,XXN,XFN,GYS,IQN,TLQ,ENY,NNY,WDS," +
            "AYN,GOQ,DSN,CIF,YIN,LLV,HMI";
    /**
     * G330:青岛、烟台、齐齐哈尔、牡丹江
     * TAO          YNT  NDG      MDG
     */
    String G330="TAO,YNT,NDG,MDG";

    /**
     * H28:青岛、烟台、威海、大连
     *
     */
    String H28="TAO,YNT,WEH,DLC";

    /**
     * W50:成都、重庆、武汉
     */
    String W50="CTU,CKG,WUH";

    String otherPKS="JMU,JXA,CDE,GMP,DQA,SHP,PNJ";
    //--------ODULO---------------------------------------------------------------------
    /**
     * B221:沈阳   SHE      0604日加唐山、青岛、烟台、威海、潍坊、大连、沈阳、齐齐哈尔、哈尔滨、牡丹江、吉林、锦州、丹东、秦皇岛、长春、长白山
     *                             TVS  TAO  YNT   WEH  WEF   DLC   SHE    NDG     HRB     MDG    JIL   JNZ  DDG   SHP    CGQ   NBS
     */
    String B221="TVS,TAO,YNT,WEH,WEF,DLC,SHE,NDG,HRB,MDG,JIL,JNZ,DDG,SHP,CGQ,NBS";
    //----------SASAN-------------------------------------------------------------------
    /**
     * SASAN:无锡、南京
     *     WUX   NKG
     */
    String SASAN="WUX,NKG";
    //-----------HSN------------------------------------------------------------------
    /**
     * W13:舟山   HSN
     */
    String W13="HSN";
    //-----------AKARA------------------------------------------------------------------
    /**
     * AKARA:日本、韩国
     *      TYO OSA SPK OKA FUK  /  SEL PUS CJU TAE CJJ
     */
    String AKARA="TYO,OSA,SPK,OKA,FUK,SEL,PUS,CJU,TAE,CJJ";
    //-----------BOLEX------------------------------------------------------------------
    /**
     * BOLEX:台湾
     * TPE  TNN   HUN   KHH   RMQ
     */
    String BOLEX="TPE,TNN,HUN,KHH,RMQ";
}
