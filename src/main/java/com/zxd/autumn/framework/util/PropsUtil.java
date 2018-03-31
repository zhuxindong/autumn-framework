package com.zxd.autumn.framework.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 属性文件助手类，封装了一些读取配置文件的通用方法
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年3月30日 下午2:54:15
* @version 1.0
*/
public final class PropsUtil {
	
	/**
	 * 日志
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);
	
	
	/**
	 * 加载属性文件
	 * @param fileName
	 * @return
	 */
	public static Properties loadProps(String fileName) {
		
		Properties properties = null;
		InputStream is = null;
		
		try {
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			
			if (is == null) {
				LOGGER.error(fileName+" file is not found");
				throw new FileNotFoundException(fileName+" file is not found");	
			}
			
			properties = new Properties();
			properties.load(is);	
			
		} catch (Exception e) {
			LOGGER.error("Load Properties File Failure",e);
			System.err.println("Load Properties File Failure,exception:"+e);
		}finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e2) {
					LOGGER.error("Close Inputstream Failure",e2);
					System.err.println("Close Inputstream Failure,exception:"+e2);
				}
			}
		}
		
		return properties;
	}
	
	
	
	
	
	/**
	 * 获取字符串类型的属性，可以通过defaultValue指定默认值
	 * @param properties
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getString(Properties properties, String key, String defaultValue) {
		
		String value = defaultValue;
		if (properties.containsKey(key)) {
			value = properties.getProperty(key);
		}
		
		return value;
	}
	
	/**
	 * 获取字符串类型的属性，默认值为空字符串
	 * @param properties
	 * @param key
	 * @return
	 */
	public static String getString(Properties properties,String key) {
		
		return getString(properties, key, "");
		
	}
	
	
	/**
	 * 获取int型的属性，可以指定默认值
	 * @param properties
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static int getInt(Properties properties, String key, int defaultValue) {
		
		int value = defaultValue;
		if (properties.containsKey(key)) {
			value = CastUtil.castInt(properties.getProperty(key));
		}
		
		return value;
		
	}
	
	
	/**
	 * 获取int型的属性，默认值为0
	 * @param properties
	 * @param key
	 * @return
	 */
	public static int getInt(Properties properties, String key) {
		
		return getInt(properties, key, 0);
		
	}
	
	
	
	/**
	 * 获取bool类型的属性，可以指定默认值
	 * @param properties
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static boolean getBoolean(Properties properties, String key, boolean defaultValue) {
		
		boolean value = defaultValue;
		
		if (properties.contains(key)) {
			
			value = CastUtil.castBoolean(properties.getProperty(key));
			
		}
		
		return value;
	}
	
	
	
	/**
	 * 获取bool类型的属性，默认值为false
	 * @param properties
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(Properties properties, String key) {
		
		return getBoolean(properties, key, false);
		
	}
	
	
	
	
	
	
	
}
