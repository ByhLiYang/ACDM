package com.hq.acdm.util.mqadapter.service.impl;

import com.hq.acdm.util.mqadapter.mqmanager.ActiveMqManager;
import com.hq.acdm.util.mqadapter.mqmanager.IMqManager;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.util.mqadapter.service.AMQService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;

/**
 * @author LiFaQiang
 * @date 2017年10月3日 上午10:14:13
 * 
 */
@Service("AMQService")
public class AMQServiceImpl extends BaseMQServiceImpl implements AMQService {
	@Override
	@Resource(name="ActiveMqManager")
	public void setMqMsgManager(IMqManager mqMsgManager) {
		super.setMqMsgManager(mqMsgManager);
	}

	@Override
	public void publish(String topicName, String message) throws JMSException {
		if (StringUtil.isNotEmpty(topicName) &&
				StringUtil.isNotEmpty(message)) {
			((ActiveMqManager) mqMsgManager).publish(topicName, message);
		}
	}
}
