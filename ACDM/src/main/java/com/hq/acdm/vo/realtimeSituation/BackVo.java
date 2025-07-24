package com.hq.acdm.vo.realtimeSituation;

import lombok.Data;

/**
 * @author LiFaQiang
 * @date 2019/04/15 01:31
 * @Description
 */
@Data
public class BackVo {

    private int [] countEHours;//小时积压
    private int [] countETotal;//累计积压
    private int [] countAll;//连线积压
}
