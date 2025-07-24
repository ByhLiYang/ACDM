package com.hq.acdm.service.sys.impl;

import com.hq.acdm.service.sys.ISysTreeService;
import com.hq.acdm.test.TestBase;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @Author lizhifeng
 * @Date 2018/8/29 0029
 * @Description:
 */
public class SysTreeServiceImplTest extends TestBase{
    @Resource
    private ISysTreeService sysTreeService;
    @Test
    public void aclTree() throws Exception {
        sysTreeService.aclTree();

    }

}