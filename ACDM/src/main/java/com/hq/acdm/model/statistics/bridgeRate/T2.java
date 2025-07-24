package com.hq.acdm.model.statistics.bridgeRate;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangshuhao
 * @date 2018/10/15 0015 17:41
 */
@Getter
@Setter
public class T2 {
            
    //T2过站or始发
    private String data_type;
    //东航
    //label="可靠"
    private int E_close;
    //label="实靠"
    private int EA_close;
    //label="靠桥率"
    private String E_close_rate;
    //label="大型机实靠"
    private int EBA_close;
    
    //label="上航"
    //label="可靠"
    private int SH_close;
    //label="实靠"
    private int SHA_close;
    //label="靠桥率"
    private String SH_close_rate;
    //label="大型机实靠"
    private int SHBA_close;
    
    //label="吉祥"
    //label="可靠"
    private int L_close;
    //label="实靠"
    private int LA_close;
    //label="靠桥率"
    private String L_close_rate;
    //label="大型机实靠"
    private int LBA_close;

    //label="国航"
    //label="可靠"
    private int C_close;
    //label="实靠"
    private int CA_close;
    //label="靠桥率"
    private String C_close_rate;
    //label="大型机实靠"
    private int CBA_close;

    //label="南航"
    //label="可靠"
    private int S_close;
    //label="实靠"
    private int SA_close;
    //label="靠桥率"
    private String S_close_rate;
    //label="大型机实靠"
    private int SBA_close;

    //label="地服"
    //label="可靠"
    private int LD_close;
    //label="实靠"
    private int LDA_close;
    //label="靠桥率"
    private String LD_close_rate;
    //label="大型机实靠"
    private int LDBA_close;

              
            
                
}
