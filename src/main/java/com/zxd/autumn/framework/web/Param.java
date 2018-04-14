package com.zxd.autumn.framework.web;

import java.util.Map;

import com.zxd.autumn.framework.util.CastUtil;

/**
* @Title: Param.java  
* @Package com.zxd.autumn.framework.web  
* @Description: 封装请求参数的类
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月13日 上午10:31:09
* @version 1.0
*/

public class Param {
	
	private Map<String, Object> paramMap;
	
	public Param() {}

	public Param(Map<String, Object> paramMap) {
		super();
		this.paramMap = paramMap;
	}

	/**
	 * 
	 * @Title: getLong  
	 * @Description: 根据参数名获取long型的参数值
	 * @return long  
	 * @param name
	 * @return
	 */
	public long getLong(String name) {
		
		return CastUtil.castLong(paramMap.get(name));
		
	}
	
	
	/**
	 * 
	 * @Title: getMap  
	 * @Description: 获取所有字段的信息
	 * @return Map<String,Object>  
	 * @return
	 */
	public Map<String, Object> getMap(){
		
		return this.paramMap;
		
	}
	
	
}
