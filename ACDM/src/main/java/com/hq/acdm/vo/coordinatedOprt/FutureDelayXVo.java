package com.hq.acdm.vo.coordinatedOprt;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2019/09/04 18:19
 * @Description
 */
@Data
public class FutureDelayXVo {
    private int nums;
    private String endtime;
    private List<FutureDelayVo> reList = new ArrayList<>();
}
