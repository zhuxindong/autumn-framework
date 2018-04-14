package com.zxd.autumn.framework.web;

/**
* @Title: Data.java  
* @Package com.zxd.autumn.framework.web  
* @Description: 返回的数据对象，该对象封装了一个Object类型的数据模型，
* 				autumn将会自动将该对象写入HttpServletResponse对象中，从而返回给浏览器
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月14日 下午2:20:12
* @version 1.0
*/

public class Data {

	private Object model;
	
	public Data() {}
	
	public Data(Object model) {
		
		this.model = model;
		
	}
	
	/**
	 * @Title: getModel  
	 * @Description: 返回数据模型
	 * @return Object  
	 * @return
	 */
	public Object getModel() {
		
		return this.model;
		
	}
	
	
	
}
