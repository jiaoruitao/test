package com.thread;

public class BuyTickets implements Runnable{
	int tickets=1000;
	@Override
	public void run() {
		while(tickets>0){
			synchronized (this) {
				if(tickets>0){
					System.out.println(Thread.
					currentThread().getName()+"当前的票数为"+tickets--);
				}

			}
		}
	}


}
