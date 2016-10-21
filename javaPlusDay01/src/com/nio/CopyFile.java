package com.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("c:/test.bin");
		FileOutputStream fos = new FileOutputStream("c:/test2.bin");
		byte[] buffer=new byte[1024];
		int len=-1;
		while((len=fin.read(buffer))!=-1){
			fos.write(buffer,0,len);
		}
		fos.flush();
		fin.close();
		fos.close();
	}

}
