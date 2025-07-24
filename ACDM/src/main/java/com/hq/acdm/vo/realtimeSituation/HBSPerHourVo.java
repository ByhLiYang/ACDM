package com.hq.acdm.vo.realtimeSituation;

import lombok.Data;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:32
 * @Description
 */
@Data
public class HBSPerHourVo {
    private List<Integer> aJHS;
    private List<Integer> aSJS;
    private List<Integer> dJHS;
    private List<Integer> dSJS;
}
