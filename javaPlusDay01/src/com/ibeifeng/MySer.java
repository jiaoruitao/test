package com.ibeifeng;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class MySer {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("c:/test.bin");
		ObjectOutputStream oos =new ObjectOutputStream(fos);
		oos.writeObject(new User("����","��",23));
		oos.writeInt(11111);
		oos.writeFloat(12321.334f);
		oos.writeBoolean(true);
		
		oos.flush();
		oos.close();
		
//		FileWriter fw=new FileWriter("c:test.txt");
//		fw.write("��˹��˹����������+qwewqqee+asdaddsa");
//		
//		fw.flush();
//		fw.close();
		
	}

}
