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
//		//�õ����������ļ��Ķ���
//		Properties properties=new Properties();
//		//���������ļ�
//		properties.load(in);
//		//��ȡ�����ļ��е�key��value
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
		//���������ļ�
		properties.load(in);
		properties.setProperty("name", "zahgnsan");
		FileOutputStream out = new FileOutputStream(new File("src/jdbc.properties"));
		properties.store(out, "this is a comment");
		System.out.println("���");
	}

}
