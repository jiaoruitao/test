package com.ibeifeng;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class MySer2 {

	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("c:/test.bin");
        ObjectInputStream ois = new ObjectInputStream(in);
        User user=(User)ois.readObject();
        int i = ois.readInt();
        float f = ois.readFloat();
        boolean b = ois.readBoolean();
        ois.close();
        System.out.println(user.getName());
        System.out.println(user.getSex());
        System.out.println(user.getId()); 
        System.out.println(i);
        System.out.println(f);
        System.out.println(b);
	}

}
