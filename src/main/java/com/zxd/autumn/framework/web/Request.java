package com.zxd.autumn.framework.web;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
* @Title: Request.java  
* @Package com.zxd.autumn.framework.web  
* @Description: 定义自己的request对象,封装请求方法与请求路径
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月12日 下午2:51:48
* @version 1.0
*/
public class Request {
	
	/**
	 * 请求方法
	 */
	private String requestMethod;
	
	/**
	 * 请求路径
	 */
	private String requestPath;

	
	public Request(String requestMethod, String requestPath) {
		super();
		this.requestMethod = requestMethod;
		this.requestPath = requestPath;
	}


	public String getRequestMethod() {
		return requestMethod;
	}

	public String getRequestPath() {
		return requestPath;
	}


	
	@Override
	public int hashCode() {
		
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	

}
