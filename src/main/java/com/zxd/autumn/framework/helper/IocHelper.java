package com.zxd.autumn.framework.helper;

import java.lang.reflect.Field;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;

import com.zxd.autumn.framework.annotation.Injection;
import com.zxd.autumn.framework.util.ReflectionUtil;

/**
* @Title: IocHelper.java  
* @Package com.zxd.autumn.framework.helper  
* @Description: 依赖注入助手类，提供依赖注入功能
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月11日 下午9:14:47
* @version 1.0
*/

public final class IocHelper {
	
	static {
		
		/**
		 * 先获取所有Bean类与Bean实例之间的映射关系（Bean Map）
		 */
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		
		if (MapUtils.isNotEmpty(beanMap)) {
			
			/** 遍历Bean Map */
			for(Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
				
				/** 获取Bean类 */
				Class<?> beanClass = beanEntry.getKey();
				/** 获取Bean的实例 */
				Object beanInstance = beanEntry.getValue();
				
				/** 获取Bean类的成员变量 */
				Field[] beanFields = beanClass.getDeclaredFields();
				
				/** 遍历成员变量并通过反射来初始化成员变量的值 */
				if (ArrayUtils.isNotEmpty(beanFields)) {
					
					for (Field beanField : beanFields) {
						
						/** 判断当前成员变量是否带有  @Injection 注解 */
						if (beanField.isAnnotationPresent(Injection.class)) {
							/** 先获取该成员变量的类型，下一步就是从容器（BeanMap）中获取该类型对应的实例 */
							Class<?> beanFieldClass = beanField.getType();
							/**
							 * 再从容器（BeanMap）中获取该类对应的实例 ，
							 * 但不一定能获取到，只有当容器中存在该类型时才会注入成功,
							 * 所以在通过反射初始化之前需要做一个非空 的判断
							 */
							Object beanFieldInstance = beanMap.get(beanFieldClass);
							
							/** 非空 的判断，只有当容器中存在该类型时，才能初始化 */
							if (beanFieldInstance != null) {
								
								/** 通过反射来初始化 */
								ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
								
								
							}
							
						}
						
						
					}
					
				}
				
			}
			
		}
		
	}
	

}
