package com.hq.acdm.vo.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hq.acdm.model.sys.SysRole;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/29 0029
 * @Description:
 */
@Data
public class AddressBook {


    private String label;

    private List<AddressBookUsers> children;

}
