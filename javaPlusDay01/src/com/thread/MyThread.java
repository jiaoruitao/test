package com.thread;

public class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println("当前线程名："+Thread.currentThread().getName());
	}

}
