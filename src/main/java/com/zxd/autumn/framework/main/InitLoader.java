package com.zxd.autumn.framework.main;

import com.zxd.autumn.framework.helper.BeanHelper;
import com.zxd.autumn.framework.helper.ClassHelper;
import com.zxd.autumn.framework.helper.ControllerHelper;
import com.zxd.autumn.framework.helper.IocHelper;
import com.zxd.autumn.framework.util.ClassUtil;

/**
* @Title: InitLoader.java  
* @Package com.zxd.autumn.framework.main  
* @Description: 框架初始化入口,加载相应的Helper类
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月13日 上午10:21:12
* @version 1.0
*/

public final class InitLoader {
	
	/**
	 * 
	 * @Title: initHelper
	 * @Description: 集中加载所有的Helper类
	 * @return void
	 */
	public static void initHelper() {
		
		Class<?>[] classList = {
			ClassHelper.class,
			BeanHelper.class,
			IocHelper.class,
			ControllerHelper.class		
		};
		
		for (Class<?> cls : classList) {
			ClassUtil.loadClass(cls.getName(),false);
		}
		
		
	}
	
	

}
