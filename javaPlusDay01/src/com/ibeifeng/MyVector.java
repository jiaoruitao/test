package com.ibeifeng;

import java.util.Iterator;
import java.util.Vector;

public class MyVector {

	public static void main(String[] args) {
		//用法参考Arraylist,线程安全
		Vector<Integer> vector = new Vector<Integer>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        //创建一个迭代器对象，遍历数据
        Iterator<Integer> iterator = vector.iterator();
        while(iterator.hasNext()){
        	System.out.println(iterator.next());
        }
	}

}
