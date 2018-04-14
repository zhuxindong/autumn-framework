package com.zxd.autumn.framework.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import com.zxd.autumn.framework.annotation.RequestMapping;
import com.zxd.autumn.framework.web.Handler;
import com.zxd.autumn.framework.web.Request;

/**
* @Title: ControllerHelper.java  
* @Package com.zxd.autumn.framework.helper  
* @Description: 请求类助手
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月12日 下午3:11:09
* @version 1.0
*/

public final class ControllerHelper {
	
	/**
	 * 用于存放request请求 与 对应的处理器 之间的映射关系
	 */
	private static final Map<Request, Handler> REQUEST_MAP = 
												new HashMap<Request, Handler>();
	
	/** 初始化 */
	static {
		
		/** 获取所有的Controller类 */
		Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
		
		if (CollectionUtils.isNotEmpty(controllerClassSet)) {
			
			/** 遍历 */
			for (Class<?> controllerClass : controllerClassSet) {
				
				/** 获取Controller类中定义的所有方法 */
				Method[] methods = controllerClass.getDeclaredMethods();
				
				if (ArrayUtils.isNotEmpty(methods)) {
					/** 遍历这些方法 */
					for (Method method : methods) {
						/** 判断当前方法是否带有 @RequestMapping 注解 */
						if (method.isAnnotationPresent(RequestMapping.class)) {
							
							/** 从requestMapping注解中获取URL映射规则 */
							RequestMapping requestMapping = 
											method.getAnnotation(RequestMapping.class);
							
							String mapping = requestMapping.value();
							
							/** 校验当前URL
							 *  校验规则是 xxx:/yyy 或 xxx:/
							 *  xxx为请求方法，yyy为请求路径
							 */
							if (mapping.matches("\\w+:/\\w*")) {
								
								String[] urlString = mapping.split(":");
								
								if (ArrayUtils.isNotEmpty(urlString) && 
										urlString.length == 2) {
									
									/** 获取请求路径 */
									String requestMethod = urlString[0];
									/** 获取请求方法 */
									String requestPath = urlString[1];
									
									/** 封装成Request对象和Handler对象 */
									Request request = new Request(requestMethod, requestPath);
									Handler handler = new Handler(controllerClass, method);
									
									/** 初始化Request Map */
									REQUEST_MAP.put(request, handler);
									
								}								
							}							
						}
					}
				}		
			}		
		}		
	}
	
	
	
	/**
	 * 
	 * @Title: getHandler  
	 * @Description: 根据请求方法和路径来获取对应的请求处理器
	 * @return Handler  
	 * @param requestMethod
	 * @param requestPath
	 * @return
	 */
	public static Handler getHandler(String requestMethod, String requestPath) {
		
		Request request = new Request(requestMethod, requestPath);
		
		return REQUEST_MAP.get(request);
		
		
	}
	
	
	

}
