package com.zxd.autumn.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Title: Controller.java  
* @Package com.zxd.autumn.framework.annotation  
* @Description: 控制器注解，功能和SpringMVC的@Controller注解类似
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月10日 下午10:12:03
* @version 1.0
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {

}
