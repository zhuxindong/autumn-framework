package com.zxd.autumn.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类操作工具类，提供一系列操作类的方法，比如获取类加载器、加载类、获取指定的类等
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年3月31日 下午12:57:34
* @version 1.0
*/

public class ClassUtil {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);
	
	
	/**
	 * 获取当前线程的类加载器
	 * @return
	 */
	public static ClassLoader getClassLoader() {
		
		return Thread.currentThread().getContextClassLoader();
		
	}
	
	
	/**
	 * 根据类的名字来加载类，并提供是否初始化的选项
	 * @param className
	 * @param isInitial
	 * @return
	 */
	public static Class<?> loadClass(String className, boolean isInitial) {
		
		Class<?> cls;
		
		try {
			cls=Class.forName(className, isInitial, getClassLoader());
		} catch (ClassNotFoundException e) {
			LOGGER.error("Load Class Failure",e);
			throw new RuntimeException(e);
		}
		
		return cls;
		
	}
	
	

}
