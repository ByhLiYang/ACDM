package com.hq.acdm.util;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2018年8月27日 下午2:17:38
 * 
 */
public class JexlUtil {
	static Logger logger= Logger.getLogger(JexlUtil.class);
	public static Object convertToCode(String jexlExp,Map<String,Object> map){
		try{
			JexlEngine jexl=new JexlEngine();
			Expression e = jexl.createExpression(jexlExp);
			JexlContext jc = new MapContext();
			for(String key : map.keySet()){
				jc.set(key, map.get(key));
			}
//			if(null==e.evaluate(jc)){
//				return "";
//			}
			return e.evaluate(jc);
		}catch(Exception ex){
			logger.error("表达式:"+jexlExp+"计算错误!"+"  参数:"+map.toString(),ex);
			throw ex;
		}
	}
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("money", "D");
		String exp="money=='A'";
		Long start = new Date().getTime();
		Object code = convertToCode(exp,map);
		System.out.println(code);
		for (int i = 0; i < 10000; i++) {
			convertToCode(exp,map);
			System.out.println(code);
		}
		Long end = new Date().getTime();
		System.out.println(end-start);
	}
}
