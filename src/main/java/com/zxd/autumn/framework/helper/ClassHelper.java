package com.zxd.autumn.framework.helper;

import java.util.HashSet;
import java.util.Set;

import com.zxd.autumn.framework.annotation.Controller;
import com.zxd.autumn.framework.annotation.Service;
import com.zxd.autumn.framework.util.ClassUtil;

/**
* @Title: ClassHelper.java  
* @Package com.zxd.autumn.framework.helper  
* @Description: 类操作助手类，为框架操作类对象提供一些定制的方法
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月11日 下午3:00:38
* @version 1.0
*/
public final class ClassHelper {
	
	/**
	 * 定义类集合，用于存放被容器加载的类
	 */
	private static final Set<Class<?>> CLASS_SET;
	/**
	 * 初始化
	 */
	static {
		
		/**
		 * 获取配置文件中的应用基础包名
		 */
		String basePackage = ConfigHelper.getAppBasePackage();
		
		/**
		 * 使用classUtil获取指定报名下的所有类
		 */
		CLASS_SET = ClassUtil.getClassSet(basePackage);
		
	}
	

	/**
	 * ---------向外提供相应的方法-------------
	 */
	
	
	/**
	 * 
	 * @Title: getClassSet  
	 * @Description: 获取应用包名下的所有类
	 * @return Set<Class<?>>  
	 */
	public static Set<Class<?>> getClassSet(){
		
		return CLASS_SET;
		
	}
	
	
	/**
	 * 
	 * @Title: getServiceClassSet  
	 * @Description: 获取应用包名下所有带有@Service注解的类
	 * @return Set<Class<?>>  
	 */
	public static Set<Class<?>> getServiceClassSet(){
		
		Set<Class<?>> serviceClassSet = new HashSet<Class<?>>();
		
		for (Class<?> cls : CLASS_SET) {
			
			if (cls.isAnnotationPresent(Service.class)) {
				serviceClassSet.add(cls);
			}
			
		}
		
		return serviceClassSet;
		
	}
	
	
	
	/**
	 * 
	 * @Title: getControllerClassSet  
	 * @Description: 获取应用包名下所有带有@Controller注解的类
	 * @return Set<Class<?>>  
	 * @return
	 */
	public static Set<Class<?>> getControllerClassSet(){
		
		Set<Class<?>> controllerClassSet = new HashSet<Class<?>>();
		
		for (Class<?> cls : CLASS_SET) {
			
			if (cls.isAnnotationPresent(Controller.class)) {
				controllerClassSet.add(cls);
			}
			
		}
		
		return controllerClassSet;
		
	}
	
	
	/**
	 * 
	 * @Title: getBeanClassSet  
	 * @Description: 获取所有Javabean（也就是带有@Service或带有@Controller的注解）
	 * @return Set<Class<?>>  
	 * @return
	 */
	public static Set<Class<?>> getBeanClassSet(){
		
		Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
		
		beanClassSet.addAll(getServiceClassSet());
		beanClassSet.addAll(getControllerClassSet());
		
		return beanClassSet;
	}
	
	
	
	
	
	
}
