package com.hq.acdm.vo.dynamicFlight;

import com.hq.acdm.util.Person;
import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2019/04/23 13:50
 * @Description
 */
@Data
public class PrcsJJJGVo implements  Comparable<PrcsJJJGVo> {
    private String flightId;
    private String flnoA;
    private String flnoD;
    private String standA;
    private String standD;
    private String adepA;
    private String adepD;
    private String adesA;
    private String adesD;
    private String runwayA;
    private String isDelay;
    private String isControl;
    private String atotA;
    private String duration;
    private String eldt;
    private String sibt;
    private String  isconflict;
    private  int seq=100;

    @Override
    public int compareTo(PrcsJJJGVo o) {
        return (o.getSeq()<this.seq)?1:((o.getSeq()==this.seq)?0:-1);
    }
}
