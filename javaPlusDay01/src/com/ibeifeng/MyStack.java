package com.ibeifeng;

import java.util.Stack;

public class MyStack {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("��Ʒ1");
		stack.push("��Ʒ2");
		stack.push("��Ʒ3");
		stack.push("��Ʒ4");
		stack.push("��Ʒ5");
		stack.push("��Ʒ6");
		//ȡ�����Ǻ����߾���,����ȡ�����û����
        //��������ʷ�����¼
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println("===================");
        for(int i=0;i<stack.size();i++){
        	System.out.println(stack.pop());
        }
        
	}

}
