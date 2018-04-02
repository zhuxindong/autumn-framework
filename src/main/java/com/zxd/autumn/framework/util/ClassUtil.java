package com.zxd.autumn.framework.util;

import java.io.FileNotFoundException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类操作工具类，提供一系列操作类的方法，比如获取类加载器、加载类、获取指定的类等
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年3月31日 下午12:57:34
* @version 1.0
*/


public class ClassUtil {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);
	
	
	/**
	 * @Title: getClassLoader  
	 * @Description: 获取当前线程的类加载器
	 * @return ClassLoader  
	 */
	public static ClassLoader getClassLoader() {
		
		return Thread.currentThread().getContextClassLoader();
		
	}
	
	
	/**
	 * 根据类的名字来加载类，并提供是否初始化的选项
	 * @param className
	 * @param isInitial
	 * @return
	 */
	public static Class<?> loadClass(String className, boolean isInitial) {
		
		Class<?> cls;
		
		try {
			cls=Class.forName(className, isInitial, getClassLoader());
		} catch (ClassNotFoundException e) {
			LOGGER.error("Load Class Failure",e);
			throw new RuntimeException(e);
		}
		
		return cls;
		
	}
	
	
	
	
	/**
	 * 
	 * @Title: getClassSet  
	 * @Description: 获取指定包名下的所有类  
	 * @param packageName
	 * @return  "Set<Class<?>>" 该包名下的类的集合
	 */
	public static Set<Class<?>> getClassSet(String packageName){
		
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		
		try {
			/**
			 * 获取指定报名下的所有类的路径
			 */
			Enumeration<URL> urls = getClassLoader().getResources(
										packageName.replace(".", "/"));
			
			
			while (urls.hasMoreElements()) {
				
				URL url = (URL) urls.nextElement();
				
				if (url != null) {
					/**
					 * 获取该URL的协议
					 */
					String protocol = url.getProtocol();
					/**
					 * 情况一：文件协议
					 */
					if ("file".equals(protocol)) {
						/**
						 * 获取该URL的路径部分，并且替换回序列化之后的空格
						 */
						String packagePath = url.getPath().replaceAll("%20", "");
						
						addClass(classSet,packagePath,packageName);
			
					}else if ("jar".equals(protocol)) {
						/**
						 * 情况二：如果是jar包
						 */
						JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
						if (jarURLConnection != null) {
							
							JarFile jarFile = jarURLConnection.getJarFile();
							
							if (jarFile != null) {
								
								Enumeration<JarEntry> jarEntries = jarFile.entries();
								
								while (jarEntries.hasMoreElements()) {
									
									JarEntry jarEntry = (JarEntry) jarEntries.nextElement();
									
									String jarEntryName = jarEntry.getName();
									
									if (jarEntryName.endsWith(".class")) {
										
										String className = jarEntryName.substring(0,
												jarEntryName.lastIndexOf(".")).replaceAll("/", ".");
										
										doAddClass(classSet,className);
										
									}
									
								}
								
							}
							
						}
						
					}
					
				}
	
			}
			
			
		} catch (Exception e) {
			LOGGER.error("Get ClassSet Failure,exception:",e);
			throw new RuntimeException(e);
		}
		
		return classSet;
	}


	
	private static void doAddClass(Set<Class<?>> classSet, String className) {
		// TODO Auto-generated method stub
		
	}


	private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	

}
