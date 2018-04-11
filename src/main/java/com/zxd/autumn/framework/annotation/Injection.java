package com.zxd.autumn.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Title: Injection.java  
* @Package com.zxd.autumn.framework.annotation  
* @Description: TODO
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月11日 下午2:59:14
* @version 1.0
*/

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Injection {

}
