package com.zxd.autumn.framework.util;



import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @Title: ReflectionUtil.java  
* @Package com.zxd.autumn.framework.util  
* @Description: 反射工具类，封装java反射相关的API，对外提供更好的通用工具和方法
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月11日 下午3:36:30
* @version 1.0
*/
public final class ReflectionUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);
	
	
	
	/**
	 * 
	 * @Title: newInstance  
	 * @Description: 初始化一个实例
	 * @return Object  
	 * @param cls
	 * @return
	 */
	public static Object newInstance(Class<?> cls) {
		
		Object instance;
		
		try {
			
			instance = cls.newInstance();
			
		} catch (Exception e) {

			LOGGER.error("New Instance Failure, exception:",e);
			
			throw new RuntimeException(e);
			
		}
		
		return instance;
	}
	
	
	/**
	 * 
	 * @Title: invokeMethod  
	 * @Description: 调用方法
	 * @return Object  
	 * @param obj
	 * @param method
	 * @param args
	 * @return
	 */
	public static Object invokeMethod(Object obj, Method method, Object...args) {
		
		Object result;
		
		try {
			
			method.setAccessible(true);
			result = method.invoke(obj, args);
			
		} catch (Exception e) {

			LOGGER.error("Invoke Method Failure,exception:",e);
			throw new RuntimeException(e);
			
		}
		
		return result;
		
	}
	
	
	/**
	 * 
	 * @Title: setField  
	 * @Description: 设置成员变量的值
	 * @return void  
	 * @param obj
	 * @param field
	 * @param value
	 */
	public static void setField(Object obj, Field field, Object value) {
		
		try {
			
			field.setAccessible(true);
			field.set(obj, value);
			
		} catch (Exception e) {

			LOGGER.error("Set Field Failure,exception:",e);
			throw new RuntimeException(e);	
		}
		
	}
	
	
	
	
	
}
