package com.thread;

public class Mtest {

	public static void main(String[] args) {
		BuyTickets bt = new BuyTickets();
        Thread thread1 = new Thread(bt);
        Thread thread2 = new Thread(bt);
        Thread thread3 = new Thread(bt);
        thread1.start();
        thread2.start();
        thread3.start();
	}

}
