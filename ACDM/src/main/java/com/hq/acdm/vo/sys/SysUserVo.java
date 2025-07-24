package com.hq.acdm.vo.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hq.acdm.model.sys.SysUser;
import com.hq.acdm.model.sys.Users;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Data
public class SysUserVo {

/*    @JsonProperty("sid")
    private Integer sid;*/

    @JsonProperty("sid")
    private String sid;

    @JsonProperty("user")
    private LoginResponseVo user;

/*    @JsonIgnore
    public LoginResponseVo adapt(SysUser sysUser) {
        LoginResponseVo vo = new LoginResponseVo();
        BeanUtils.copyProperties(sysUser, vo);
        this.user = vo;
        return vo;
    }*/
    @JsonIgnore
    public LoginResponseVo adapt(Users user) {
        LoginResponseVo vo = new LoginResponseVo();
//        BeanUtils.copyProperties(user, vo);
        vo.setId(user.getEmployeeId());
        vo.setUsername(user.getUserName());
        vo.setAirline(user.getDepartment());
        vo.setDept(user.getDept());
        if ("AocU03".equals(user.getEmployeeId())){
            vo.setTelNum("1003");
            vo.setSsNum("91003");
        }else if ("AocU04".equals(user.getEmployeeId())){
            vo.setTelNum("1004");
            vo.setSsNum("1004");
        }else if ("AocU05".equals(user.getEmployeeId())){
            vo.setTelNum("1005");
            vo.setSsNum("91005");
        }else if ("HB01".equals(user.getEmployeeId())){
            vo.setTelNum("1001");
            vo.setSsNum("91001");
        }else if ("HB02".equals(user.getEmployeeId())){
            vo.setTelNum("1002");
            vo.setSsNum("91002");
        }else if ("HB06".equals(user.getEmployeeId())){
            vo.setTelNum("1006");
            vo.setSsNum("91006");
        }else{
            vo.setTelNum("1050");
            vo.setSsNum("91050");
        }

        this.user = vo;
        return vo;
    }
}
