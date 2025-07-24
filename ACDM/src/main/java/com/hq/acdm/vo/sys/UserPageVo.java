package com.hq.acdm.vo.sys;

import com.hq.acdm.param.sys.UserParam;
import lombok.Data;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/28 0028
 * @Description:
 */
@Data
public class UserPageVo {
    List<UserParam> records;

    Integer total;
}
