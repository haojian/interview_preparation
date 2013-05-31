package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chopstic[] chops = new Chopstic[10];
		Philosopher[] phils = new Philosopher[10];
		Thread[] people = new Thread[10];
		for(int i=0; i<chops.length; i++)
			chops[i] = new Chopstic();
		for(int i=0; i<phils.length-1; i++)
		{
			phils[i] = new Philosopher(chops[i], chops[i+1]);
		}
		phils[phils.length-1] = new Philosopher(chops[phils.length-1], chops[0]);
		
		for(int i=0; i<phils.length; i++){
			people[i] = new Thread(phils[i]);
			people[i].start();
		}
	}

}

class Philosopher implements Runnable{
	private Chopstic left, right;
	int bites = 10;
	public Philosopher(Chopstic _left, Chopstic _right){
		left = _left;
		right = _right;
	}
	
	public boolean eat(){
		if(!left.pickup())
			return false;
		if(!right.pickup()){
			left.putdown();
			return false;
		}
		chew();
		left.putdown();
		right.putdown();
		
		return true;
	}
	
	public void chew(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(bites > 10){
			if(eat()){
				bites--;
			}else{
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("I finished");
	}
}

class Chopstic{
	private Lock lock;
	public Chopstic(){
		lock = new ReentrantLock();
	}
	
	public boolean pickup(){
		return lock.tryLock();
	}
	
	public void putdown(){
		lock.unlock();
	}
}