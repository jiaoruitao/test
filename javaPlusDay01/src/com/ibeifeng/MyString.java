package com.ibeifeng;

import java.io.UnsupportedEncodingException;

public class MyString {

	public static void main(String[] args) throws UnsupportedEncodingException {
//		String str1="hello";
//		String str2="hello";
//		String str3=new String("hello");
//		String str4=new String("hello");
//		System.out.println(str1==str2);
//		System.out.println(str1==str3);
//		System.out.println(str3==str4);
		
//		String str="welcome to beifeng";
//		int num = str.indexOf("e");
//	    String  str1=new String(str.getBytes("gbk"),"utf-8");
//	    System.out.println(str1);
	    
	    final int NUM=50000;
	    String str2=new String("hello");
	    Long start=System.currentTimeMillis();
	    for(int i=0;i<NUM;i++){
	    	str2=str2+i;
	    }
	    Long end=System.currentTimeMillis();
	    System.out.println("字符串连接时间"+(end-start));
	    
	    
	    StringBuffer str3=new StringBuffer("hello");
	    Long start1=System.currentTimeMillis();
	    for(int i=0;i<NUM;i++){
	    	str3.append(i);
	    }
	    Long end1=System.currentTimeMillis();
	    System.out.println("stringBuffer字符串连接时间"+(end1-start1));
	    
	    StringBuilder str4=new StringBuilder("hello");
	    Long start2=System.currentTimeMillis();
	    for(int i=0;i<NUM;i++){
	    	str4.append(i);
	    }
	    Long end2=System.currentTimeMillis();
	    System.out.println("stringBuildre字符串连接时间"+(end2-start2));
	    
	}
}
