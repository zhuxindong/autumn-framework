package com.zxd.autumn.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Title: Service.java  
* @Package com.zxd.autumn.framework.annotation  
* @Description: 服务类注解，类似于SpringMVC的@Service注解
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月11日 下午2:48:32
* @version 1.0
*/

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {

}
