package com.zxd.autumn.framework.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @Title: StreamUtil.java  
* @Package com.zxd.autumn.framework.util  
* @Description: 流操作工具类
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年4月14日 下午2:52:03
* @version 1.0
*/

public final class StreamUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);
	
	/**
	 * 
	 * @Title: getString  
	 * @Description: 从输入流中获取字符串
	 * @return String  
	 * @param is
	 * @return
	 */
	public static String getString(InputStream is) {
		
		StringBuffer sb = new StringBuffer();
		
		try {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			
			String line;
			
			while((line = reader.readLine()) != null) {
				
				sb.append(line);
				
			}
			
		} catch (Exception e) {

			LOGGER.error("Get String Failure,exception:"+e);
			throw new RuntimeException(e);
		}
		
		return sb.toString();
		
	}
	
	
}
