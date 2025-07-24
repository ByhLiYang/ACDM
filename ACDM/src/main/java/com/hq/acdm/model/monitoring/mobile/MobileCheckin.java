package com.hq.acdm.model.monitoring.mobile;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/** 日报信息
 * @author tonnychen
 * @date 2018/10/22 0020 14:29
 */
@Getter
@Setter
public class MobileCheckin {
    private Integer id;
    private String userId;
    private String deviceToken;//设备码
    private String deviceType;//设备类型 ios,android
    private String times;//航班号
    private Timestamp createTime;//机位

    private String version;//标题
    private Timestamp loginTime;//标题
    private Timestamp logoutTime;//标题


    private Integer status;//状态 0 未发送 1-发送  2-接收   3-处理







}