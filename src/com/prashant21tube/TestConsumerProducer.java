package com.prashant21tube;

public class TestConsumerProducer {

	public static void main(String[] args) throws InterruptedException {
		PC pc = new PC();
		
		// Create producer thread
			Thread t1 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						pc.produce();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			
			// Create consumer thread
			Thread t2 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						pc.consume();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
	}

}
