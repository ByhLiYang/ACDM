package com.hq.acdm.vo.dynamicFlight;

import lombok.Data;

@Data
public class XlVo {

    private int  xj;//卸机总数
    private String xjs;//卸机开始
    private String xjend;//卸机结束
    private int  dd;//到达
    private String dds;//到达开始
    private String ddend;//到达结束
    private int  zj;//值机
    private String zjs;//值机开始
    private String zjend;//值机结束
    private int  aj;//安检
    private String ajs;//安检开始
    private String ajend;//安检结束
    private int   fj;//分拣
    private String fjs;//分拣开始
    private String fjend;//分拣结束
    private int   zc;//装车
    private String zcs;//装车开始
    private String zcend;//装车结束
    private int  zji;//装机
    private String zjis;//装机开始
    private String zjiend;//装机结束


}
