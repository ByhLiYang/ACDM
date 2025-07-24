package com.hq.acdm.vo.index;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/9/3 0003
 * @Description:
 */
@Data
public class DelayFlightVo {

    private List<BigDecimal> executedList;

    private List<BigDecimal> nonExecutionList;

}
