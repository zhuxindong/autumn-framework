package com.zxd.autumn.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Title: RequestMapping.java  
* @Package com.zxd.autumn.framework.annotation  
* @Description: 类似SpringMVC中的@RequestMapping注解
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月10日 下午10:25:47
* @version 1.0
*/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
	
	/**
	 * @Title: value  
	 * @Description: 请求的类型与路径
	 * @return String  
	 * @return
	 */
	String value();

}
