package com.zxd.autumn.framework.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


import com.zxd.autumn.framework.util.ReflectionUtil;

/**
* @Title: BeanHelper.java  
* @Package com.zxd.autumn.framework.helper  
* @Description: Javabean助手类，相当于一个bean容器，存放了bean类与bean实例之间的映射关系
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月11日 下午4:05:59
* @version 1.0
*/
public final class BeanHelper {
	
	
	/**
	 * 定义bean映射，用于存放bean类和bean实例之间的映射关系
	 */
	private static final Map<Class<?>, Object> BEAN_MAP = 
												new HashMap<Class<?>, Object>();
	
	/**
	 * 初始化
	 */
	static {
		
		Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
		
		for (Class<?> cls : beanClassSet) {
			
			Object obj = ReflectionUtil.newInstance(cls);
			
			BEAN_MAP.put(cls, obj);
			
		}
			
	}
	
	
	/**
	 * @Title: getBeanMap  
	 * @Description: 向外提供获取bean映射的方法
	 * @return  Map&ltClass<?>,Object>
	 */
	public static Map<Class<?>, Object> getBeanMap(){
		
		return BEAN_MAP;
		
	}
	
	
	/**
	 * 
	 * @Title: getBean  
	 * @Description: 获取bean的实例
	 * @return T  
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> cls) {
		
		if (!BEAN_MAP.containsKey(cls)) {
			throw new RuntimeException("Can Not Get Bean By Class: "+cls);
		}
		
		return (T) BEAN_MAP.get(cls);
		
	}
	
	

}
