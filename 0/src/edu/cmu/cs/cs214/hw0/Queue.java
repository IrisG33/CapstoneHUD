package edu.cmu.cs.cs214.hw0;

public class Queue {
	
	private Object[] queueArray;
	int front;
	int back;
	int nItem;
	
	/*
	 * Constructor
	 */
	public Queue(){
		queueArray = new Object[50];
		front = 0;
		back = -1;
		nItem = 0;
	}
	
	/*
	 * add element into the queue at the end
	 */
	public void enqueue(Object o){
		if(isFull()) throw new RuntimeException("Queue is full");
		back++;
		int index = back%queueArray.length;
		queueArray[index] = o;
		nItem ++;
	}
	
	/*
	 * remove element from the queue at the head
	 */
	public Object dequeue(){
		if(nItem == 0) throw new RuntimeException("Nothing in the queue");
		int index = front%queueArray.length;
		Object element = queueArray[index];
		queueArray[index] = null;
		front ++;
		nItem --;
		return element;
	}
	
	/*
	 * helper method to check if the queue is full
	 */
	private boolean isFull(){
		return nItem == queueArray.length;
	}
	
	/*
	 * check is the queue is empty
	 */
	public boolean isEmpty(){
		return nItem == 0;
	}

}
