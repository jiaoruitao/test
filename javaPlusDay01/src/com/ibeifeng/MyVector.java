package com.ibeifeng;

import java.util.Iterator;
import java.util.Vector;

public class MyVector {

	public static void main(String[] args) {
		//�÷��ο�Arraylist,�̰߳�ȫ
		Vector<Integer> vector = new Vector<Integer>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        //����һ�����������󣬱�������
        Iterator<Integer> iterator = vector.iterator();
        while(iterator.hasNext()){
        	System.out.println(iterator.next());
        }
	}

}
