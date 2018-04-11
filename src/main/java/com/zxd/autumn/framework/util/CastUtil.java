package com.zxd.autumn.framework.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于类型转换的工具类
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年3月30日 下午8:16:04
* @version 1.0
*/
public final class CastUtil {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CastUtil.class);
	
	
	/**
	 * 转换为string类型，可以指定默认值defaultValue
	 * @param object
	 * @param defaultValue
	 * @return
	 */
	public static String castString(Object object, String defaultValue) {
		
		String value = defaultValue;
		
		if (object != null) {
			value = String.valueOf(object);
		}
		
		return value;
	}
	
	
	/**
	 * @Title: castString  
	 * @Description: 转换为string类型，默认值为空字符串
	 * @return String  
	 * @param object
	 */
	public static String castString(Object object) {
		
		return CastUtil.castString(object, "");
		
	}
	
	
	
	/**
	 * 转换为double类型，可以指定默认值defaultValue
	 * @param object
	 * @param defaultValue
	 * @return
	 */
	public static double castDouble(Object object, double defaultValue) {
		
		double value = defaultValue;
		
		if (object != null) {
			String strValue = String.valueOf(object);
			/**
			 * 在某些情况下，strValue可能是空字符串"  "，所以trim是必要的
			 */
			if (!StringUtils.isEmpty(strValue.trim())) {
				try {
					value = Double.parseDouble(strValue);
				} catch (Exception e) {
					LOGGER.error("The configuration file is in the wrong format. "
							+ "Please check it",e);
					System.err.println("The configuration file is in the wrong format. "
							+ "Please check it,exception:"+e);
				}
			}
		}
		
		return value;
		
	}
	
	
	/**
	 * 转换为double类型，默认值为0
	 * @param object
	 * @return
	 */
	public static double castDouble(Object object) {
		
		return CastUtil.castDouble(object, 0);
	}
	
	
	
	/**
	 * 转换为long类型，可以指定默认值defaultValue
	 * @param object
	 * @param defaultValue
	 * @return
	 */
	public static long castLong(Object object, long defaultValue) {
		
		long value = defaultValue;
		
		if (object != null) {
			String strValue = String.valueOf(object);
			/**
			 * 在某些情况下，strValue可能是空字符串"  "，所以trim是必要的
			 */
			if (!StringUtils.isEmpty(strValue.trim())) {
				
				try {
					value = Long.parseLong(strValue);
				} catch (Exception e) {
					LOGGER.error("The configuration file is in the wrong format. "
							+ "Please check it",e);
					System.err.println("The configuration file is in the wrong format. "
							+ "Please check it,exception:"+e);
				}
			}
		}
		
		return value;
		
	}
	
	
	
	/**
	 * 转换为long类型，默认值为0
	 * @param object
	 * @return
	 */
	public static long castLong(Object object) {
		
		return CastUtil.castLong(object, 0);
		
	}
	
	
	
	
	
	/**
	 * 转换为int类型，可以指定默认值defaultValue
	 * @param object
	 * @param defaultValue
	 * @return
	 */
	public static int castInt(Object object, int defaultValue) {
		
		int value = defaultValue;
		
		if (object != null) {
			String strValue = String.valueOf(object);
			/**
			 * 在某些情况下，strValue可能是空字符串"  "，所以trim是必要的
			 */
			if (!StringUtils.isEmpty(strValue.trim())) {
				try {
					value = Integer.parseInt(strValue);
					
				} catch (Exception e) {
					LOGGER.error("The configuration file is in the wrong format. "
							+ "Please check it",e);
					System.err.println("The configuration file is in the wrong format. "
							+ "Please check it,exception:"+e);
				}
			}
		}
		
		return value;
		
	}
	
	
	/**
	 * 转换为int类型，默认值为0
	 * @param object
	 * @return
	 */
	public static int castInt(Object object) {
		
		return CastUtil.castInt(object, 0);
	}
	
	
	
	/**
	 * 转换为bool类型，可以提供默认值defaultValue
	 * @param object
	 * @param defaultValue
	 * @return
	 */
	public static boolean castBoolean(Object object, boolean defaultValue) {
		
		boolean value = defaultValue;
		
		if (object != null) {
			value = Boolean.parseBoolean(castString(object));
		}
		
		return value;
	}
	
	
	
	/**
	 * 转换为Boolean类型，默认值为false
	 * @param object
	 * @return
	 */
	public static boolean castBoolean(Object object) {
		
		return CastUtil.castBoolean(object, false);
		
	}
	
	
	
	
	
	
}
