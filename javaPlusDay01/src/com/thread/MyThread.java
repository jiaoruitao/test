package com.thread;

public class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println("��ǰ�߳�����"+Thread.currentThread().getName());
	}

}
