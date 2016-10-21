package com.ibeifeng;

import java.util.Stack;

public class MyStack {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("商品1");
		stack.push("商品2");
		stack.push("商品3");
		stack.push("商品4");
		stack.push("商品5");
		stack.push("商品6");
		//取数据是后来者居上,并且取出后就没有了
        //可用作历史浏览记录
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println("===================");
        for(int i=0;i<stack.size();i++){
        	System.out.println(stack.pop());
        }
        
	}

}
