package com.prashant21tube;

import java.util.LinkedList;

public class PC {

	 // Create a list shared by producer and consumer 
    // Size of list is 3. 
	int capacity = 3;
	LinkedList<Integer> myList = new LinkedList<>();

	public void produce() throws InterruptedException {

		int value = 0;

		while (true) {

			synchronized (this) {
				while(myList.size() == capacity)
					wait();

				System.out.println("Producer produced. " + value);
				
				// to insert the jobs in the list 
				myList.add(value++);

				// notifies the consumer thread that 
                // now it can start consuming 
				notify();

				// makes the working of program easier 
                // to  understand 
				Thread.sleep(1000);
			}

		}

	}

	public void consume() throws InterruptedException {

		while (true) {
			
			synchronized (this) {
				// consumer thread waits while list 
                // is empty
				while(myList.size() == 0)
					wait();

				// to retrive the ifrst job in the list 
				int removed = myList.removeFirst();
				System.out.println("Consumer consumed. " + removed);

				// Wake up producer thread 
				notify();

				Thread.sleep(1000);
			}
			
		}
	}

}
