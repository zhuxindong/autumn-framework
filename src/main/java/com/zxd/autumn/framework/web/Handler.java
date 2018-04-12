package com.zxd.autumn.framework.web;

import java.lang.reflect.Method;

/**
* @Title: Handler.java  
* @Package com.zxd.autumn.framework.web  
* @Description: 用于处理请求的对象
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月12日 下午3:05:49
* @version 1.0
*/

public class Handler {
	
	/**
	 * Controller类
	 */
	private Class<?> controllerClass;
	
	/**
	 * requestMapping 方法
	 */
	private Method requestMappingMethod;

	public Handler(Class<?> controllerClass, Method requestMappingMethod) {
		super();
		this.controllerClass = controllerClass;
		this.requestMappingMethod = requestMappingMethod;
	}

	public Class<?> getControllerClass() {
		return controllerClass;
	}


	public Method getRequestMappingMethod() {
		return requestMappingMethod;
	}


	
	
	
	
	

}
