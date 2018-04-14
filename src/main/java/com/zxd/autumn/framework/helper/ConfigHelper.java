package com.zxd.autumn.framework.helper;

import java.util.Properties;

import com.zxd.autumn.framework.constant.ConfigConstant;
import com.zxd.autumn.framework.util.PropsUtil;

/**
 * 配置文件工具类，用来读取配置文件；
 * 该类依赖于PropsUtil,PropsUtil封装了通用的读取配置项的方法，
 * 而ConfigHelper用通用的PropsUtil来读取autumn-frameword的配置文件
 * @see PropsUtil
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年3月30日 下午10:09:31
* @version 1.0
* @since 1.0.0
*/
public final class ConfigHelper {
	
	/**
	 * 加载配置文件，文件名为"autumn-framework"
	 * @see ConfigConstant.CONFIG_PROPS
	 */
	private static final Properties CONFIG_PROPS = 
									PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

	
	/**
	 * 获取JDBC驱动
	 */
	public static String getJDBCDriver() {
		
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
		
	}
	
	/**
	 * 获取JDBC URL
	 */
	public static String getJDBCUrl() {
		
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
		
	}
	
	
	
	/**
	 * 获取 JDBC 用户名
	 */
	public static String getJDBCUserName() {

		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
		
	}
	
	
	/**
	 * 获取 JDBC 密码
	 */
	public static String getJDBCPassWord() {
		
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
		
	}
	
	
	
	
	/**
	 * 获取应用基础包名
	 */
	public static String getAppBasePackage() {
		
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
		
	}
	
	
	/**
	 * 获取jsp文件的路径
	 */
	public static String getAppJspPath() {
		
		/**
		 * 设置默认路径为 /WEB-INF/view/
		 */
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH,
									"/WEB-INF/view/");
		
	}
	
	
	/**
	 * 获取静态资源路径，默认在/static/路径下
	 */
	public static String getAppStaticPath() {
		
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_STATIC_PATH,
									"/static/");
		
	}
	
	
	
	
}
