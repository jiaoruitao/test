package com.ibeifeng;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class MyPro {

	public static void main(String[] args) throws Exception {
//		File file=new File("src/jdbc.properties");
//		FileInputStream in=new FileInputStream(file);
//		System.out.println(in);
//		//得到解析属性文件的对象
//		Properties properties=new Properties();
//		//解析属性文件
//		properties.load(in);
//		//获取属性文件中的key和value
//		String driverClass = properties.getProperty("driverClass");
//		String url = properties.getProperty("url");
//		String username = properties.getProperty("username");
//		String password = properties.getProperty("password");
//	
//		System.out.println(driverClass);
//		System.out.println(url);
//		System.out.println(username);
//		System.out.println(password);
		
		InputStream in=MyPro.class.getResourceAsStream("/jdbc.properties");
		Properties properties=new Properties();
		//解析属性文件
		properties.load(in);
		properties.setProperty("name", "zahgnsan");
		FileOutputStream out = new FileOutputStream(new File("src/jdbc.properties"));
		properties.store(out, "this is a comment");
		System.out.println("完成");
	}

}
