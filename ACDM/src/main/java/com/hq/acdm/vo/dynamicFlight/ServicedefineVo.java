package com.hq.acdm.vo.dynamicFlight;

import lombok.Data;

@Data
public class ServicedefineVo {
    //催促消息实体类
    private String sender;//发送人id
    private String flightId;//航班唯一标识
    private String flno;//航班号
    private String nodeCode;//节点代码


}
