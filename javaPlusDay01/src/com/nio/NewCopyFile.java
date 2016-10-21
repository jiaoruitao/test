package com.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NewCopyFile {

	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("c:/test.bin");
		FileOutputStream fos = new FileOutputStream("c:/test4.bin");
		FileChannel fic = fin.getChannel();
		FileChannel foc = fos.getChannel();
		ByteBuffer bb=ByteBuffer.allocate(1024);
		while(fic.read(bb)!=-1){
			bb.flip();
			foc.write(bb);
			bb.clear();
		}
        fin.close();
        fos.close();
        fic.close();
        foc.close();
	}

}
