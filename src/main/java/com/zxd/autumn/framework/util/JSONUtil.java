package com.zxd.autumn.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
* @Title: JSONUtil.java  
* @Package com.zxd.autumn.framework.util  
* @Description: JSON工具类，基于jackson实现
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月14日 下午3:05:27
* @version 1.0
*/

public final class JSONUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JSONUtil.class);
	
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	
	/**
	 * 
	 * @Title: toJSON  
	 * @Description: 将POJO转换为JSON
	 * @return String  
	 * @param object
	 * @return
	 */
	public static <T> String toJSON(T object) {
		
		String json;
		
		try {
			
			json = OBJECT_MAPPER.writeValueAsString(object);		
			
		} catch (Exception e) {
		
			LOGGER.error("Convert POJO to JSON Failure,exception:"+e);
			throw new RuntimeException(e);
			
		}
		
		return json;
		
	}
	
	
	
	/**
	 * 
	 * @Title: toPOJO  
	 * @Description: 将JSON转化为POJO
	 * @return T  
	 * @param json
	 * @param tyep
	 * @return
	 */
	public static <T> T toPOJO(String json, Class<T> tyep) {
		
		T pojo;
		
		try {
			
			pojo = OBJECT_MAPPER.readValue(json, tyep);
			
		} catch (Exception e) {

			LOGGER.error("Convert JSON to POJO Failure,exception:"+e);
			throw new RuntimeException(e);
			
		}
		
		return pojo;
		
	}
	
	
	
	
	
	
	
	
	
	

}
