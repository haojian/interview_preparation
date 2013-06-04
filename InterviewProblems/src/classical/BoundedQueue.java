package classical;

import java.io.InputStreamReader;
import java.io.Reader;

public class BoundedQueue {

	  private static Reader in = 
		         new InputStreamReader(System.in);

		   private static char getNextChar() {
		      char ch = ' ';
		      try {
		         ch = (char)in.read();
		      }
		      catch (Exception exception) {
		         System.err.println("Read Error");
		         ch = ' ';
		      }
		      return ch;
		   }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoundedQueue queue = new BoundedQueue(4); // 10 chars
	      char ch;
	      while ((ch = getNextChar()) != 'q') {
	         switch (ch) {
	         case 'i':
	            ch = getNextChar();
	            queue.insert(ch);
	            System.out.println(ch + " inserted");
	            break;
	         case 'd':
	            System.out.println(queue.dequeue() + 
	               " deleted");
	            break;
	         case 'p':
	            queue.printq();
	            break;
	         default: System.out.println("Input error");
	         }
	         while ((ch = getNextChar()) != '\n')
	            ;
	      }
	}
	
	private int qMaxSize = 0;
	private int fi = 0;  
	private int ri = 0;   
	private int qs = 0;
	private Character[] q;
	
	public BoundedQueue(int initsize){
		qMaxSize = initsize;
		q = new Character[qMaxSize];
		fi =0;
		ri =0;
		qs =0;
	}
	
	public Character dequeue(){
		if(this.ifempty()){
			System.out.println("no element in the queue");
			return null;
		}else{
			qs--;
			Character res = q[fi];
			q[fi] = null;
			fi++;
			fi = fi%qMaxSize;
			return res;
		}
	}
	
	public void insert(Character c){
		if(this.fullq()){
			System.out.println("full queue");
		}
		else{
			q[ri] = c;
			qs++;
			ri++;
			ri = ri%qMaxSize;
		}
	}
	
	public boolean ifempty(){
		return qs == 0;
	}
	
	public boolean fullq(){
		return qs == qMaxSize;
	}
	
	 public void printq() {
		      System.out.print("Size: " + qs +
		         ", ri: " + ri + ", fi: " + fi + ", q: ");
		      for (int i = 0; i < qMaxSize; i++)
		         System.out.print("q[" + i + "]=" 
		            + q[i] + "; ");
		      System.out.println();
		   }

}
