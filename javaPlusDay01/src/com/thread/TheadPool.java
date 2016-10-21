package com.thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TheadPool {

	public static void main(String[] args) {
//		ExecutorService ctp = Executors.newCachedThreadPool();
//		for (int i = 0; i < 100; i++) {
//			MyThread myThread = new MyThread();
//			//myThread.start();
//			ctp.execute(myThread);
//		}
//		ctp.shutdown();
		
		
//		ExecutorService ctp = Executors.newFixedThreadPool(10);
//		for (int i = 0; i < 50; i++){
//			MyThread myThread = new MyThread();
//			ctp.execute(myThread);
//		}
//		ctp.shutdown();
		
		
//		ExecutorService stp = Executors.newSingleThreadExecutor();
//		for (int i = 0; i < 50; i++) {
//			MyThread myThread = new MyThread();
//			stp.execute(myThread);
//			
//		}
//		stp.shutdown();
		
		
		ScheduledThreadPoolExecutor stpe =
				new ScheduledThreadPoolExecutor(10);
		for (int i = 0; i < 50; i++) {
			MyThread myThread = new MyThread();
		stpe.scheduleAtFixedRate(myThread, 1000, 2000, TimeUnit.MILLISECONDS);
		}
		//stp.shutdown();
		System.out.println("Íê³É");
	}

}
