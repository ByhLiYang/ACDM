package com.hq.acdm.service.specialCase.infoPublish.impl;

import com.hq.acdm.dao.specialCase.InfoPublishMapper;
import com.hq.acdm.model.specialCase.infoPublish.infoPublish;
import com.hq.acdm.model.specialCase.infoPublish.infoPublishResult;
import com.hq.acdm.service.specialCase.infoPublish.InfoPublishService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/23 0023 13:43
 */
@Service("InfoPublishService")
public class InfoPublishServiceImpl implements InfoPublishService {
    @Resource
    private InfoPublishMapper infoPublishMapper;
    @Override
    public List<infoPublishResult> queryInfoPublish(Map<String, Object> map) {
        return infoPublishMapper.queryInfoPublish(map);
    }

    @Override
    public int addInfoPublish(infoPublish infoPublish) {
        return infoPublishMapper.addInfoPublish(infoPublish);
    }
}
