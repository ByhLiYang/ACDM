package com.hq.acdm.vo.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TSkFareDetailed;
import lombok.Data;

import java.util.ArrayList;

/**
 * @author LiFaQiang
 * @date 2019/04/15 01:31
 * @Description
 */
@Data
public class SKVo {

    private ArrayList<TSkFareDetailed> jzs=new ArrayList<TSkFareDetailed>();//机组
    private ArrayList<TSkFareDetailed> lks=new ArrayList<TSkFareDetailed>();//旅客

}
