package com.hq.acdm.service.coordinatedOprt.impl;


import com.hq.acdm.dao.coordinatedOprt.FlowControlInformationMapper;
import com.hq.acdm.service.coordinatedOprt.FlowControlInformationService;
import com.hq.acdm.vo.coordinatedOprt.FlowControlInfoTControlInfoVo;
import com.hq.acdm.vo.coordinatedOprt.FlowControlInfoTMdrsVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class FlowControlInformationServiceImpl implements FlowControlInformationService {

    @Resource
    private FlowControlInformationMapper flowControlInformationMapper;


    @Override
    public List<FlowControlInfoTMdrsVo> findFlowControlInfoTMdrs(Map params) {
        return flowControlInformationMapper.findFlowControlInfoTMdrs(params);
    }

    @Override
    public List<FlowControlInfoTControlInfoVo> findFlowControlInfoTControlInfo(Map params) {
        return flowControlInformationMapper.findFlowControlInfoTControlInfo(params);
    }
}
