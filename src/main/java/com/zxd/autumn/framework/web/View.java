package com.zxd.autumn.framework.web;

import java.util.HashMap;
import java.util.Map;

/**
* @Title: View.java  
* @Package com.zxd.autumn.framework.web  
* @Description: 返回的视图对象，每个视图包含两个重要成员:path和model; 
* 				path是该视图的路径，model是该视图包含的数据;
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月14日 下午2:12:26
* @version 1.0
*/

public class View {
	
	/**
	 * 视图的路径
	 */
	private String path;
	
	/**
	 * 该视图的数据
	 */
	private Map<String, Object> model;
	
	public View() {}
	
	public View(String path) {
		
		this.path = path;
		this.model = new HashMap<String, Object>();
		
	}
	
	
	/**
	 * @Title: addModel  
	 * @Description: 为视图添加数据
	 * @return View  
	 * @param key
	 * @param value
	 * @return
	 */
	public View addModel(String key, Object value) {
		
		this.model.put(key, value);
		return this;
	}
	
	
	/**
	 * @Title: getPath  
	 * @Description: 获取视图的路径
	 * @return String  
	 * @return
	 */
	public String getPath() {
		
		return this.path;
		
	}
	
	
	
	/**
	 * 
	 * @Title: getModel  
	 * @Description: 获取视图的数据
	 * @return Map<String,Object>  
	 * @return
	 */
	public Map<String, Object> getModel(){
		
		return this.model;
		
	}
	
	
	
	
	
	
	

}
