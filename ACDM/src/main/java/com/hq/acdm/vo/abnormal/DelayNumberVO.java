package com.hq.acdm.vo.abnormal;

import com.hq.acdm.vo.supervision.managermonitor.DateName;
import com.hq.acdm.vo.supervision.managermonitor.FourD;
import lombok.Data;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/9/27 0027
 * @Description:
 */
@Data
public class DelayNumberVO {

    private int[] executedList;
    private int[] nonExecutionList;

}
