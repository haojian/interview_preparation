package Sixteen;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ThreadsafeBlockingQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue queue = new BlockingQueue();
		Thread consumer = new Thread(new Consumer(queue));
		Thread producer = new Thread(new Producer(queue));
		consumer.start();
		producer.start();
	}

}

class Consumer implements Runnable{
	private Queue queue = null;
	
	public Consumer(Queue q){
		queue = q;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) { 
            doStuff();
        }
	}
	
    public void doStuff() {
        Object msg = ((BlockingQueue) queue).dequeue();
        process(msg);
    }
    
    public void process(Object msg) {
        try {
            //process message non-trivially (IE: it takes awhile).
        	System.out.println(msg);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable{
	private Queue queue = null;
	
	public Producer(Queue q){
		queue = q;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		doSomething("test");
	}
	
	
	public void doSomething(Object msg) {
        ((BlockingQueue) queue).enqueue(msg);
    }
}

class BlockingQueue extends LinkedList implements Queue{
	private Queue queue = new LinkedList();
	
	public synchronized Object dequeue(){
		Object msg = null;
		while(queue.isEmpty()){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return msg;
				//e.printStackTrace();
			}
		}
		msg = queue.remove();
		return msg;
	}
	
	public synchronized void enqueue(Object obj){
		queue.add(obj);
		notifyAll();
	}
} 
