package predict;

import java.util.HashMap;
import java.util.Map;

public class Square1 {

	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] input = {3, 4, 3, 2, 3, -1, 3, 3};
		//int[] input = {3, 4, 3, 2};
		//int[] input = {-2147483648 ,  1, 4, 2147483647};
		//System.out.println(solution2(input));
		int[] input4 = {1, 5, 2, 1, 4, 0};
		System.out.println(solution4(input4));
	}

	  public static int solution ( int[] A ) {
		  if(A== null || A.length == 0)
			  return -1;
		  int x = 0;
		  int index=-1;
		  int counter = 0;
		  //find the most frequent one.
		  for(int i=0; i<A.length; i++){
			  if(counter == 0) {
				  x = A[i];
				  index = i;
				  counter++;
			  }else if(x == A[i]){
				  counter++;
			  }else{
				  counter--;
			  }
		  }
		  //check if domi.
		  long domiCounter = 0;
		  for(int i=0;i<A.length; i++){
			  if(A[i] == x){
				  domiCounter++;
			  }
		  }
		  
		  if(domiCounter *2 > A.length)
			  return index;
		  return -1;
	  }
	  
	  public static int solution2 ( int[] A ) {
		  if(A== null || A.length == 0)
			  return -1;
		  int[] maxLeft = new int[A.length];
		  maxLeft[0] = A[0];
		  for(int i=1; i<A.length; i++){
			  maxLeft[i] = Math.max(A[i], A[i-1]);
		  }
		  int min = Integer.MAX_VALUE;
		  
		  for(int i=A.length-1; i>0; i--){
			  if(A[i] >= maxLeft[i-1] && A[i] <= min){
				  return i;
			  }
			  min = Math.min(min, A[i]);
		  }
		  if(A[0]<=min){
			  return 0;
		  }
		  return -1;
	  }
	  
	  
	  public int solution3 ( int[] A ) {
	      if(A == null || A.length == 0){
	          return -1;
	      }
	      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	      for(int ele : A){
	           if(!map.containsKey(ele))
	               map.put(ele, 0);
	          map.put(ele, map.get(ele)+1);
	      }
	      Map<Integer, Integer> kindsMap = new HashMap<Integer, Integer>();
	      for(int i=0; i<A.length; i++){
	          if(!kindsMap.containsKey(A[i])){
	              kindsMap.put(A[i], 0);
	              if(kindsMap.size() == map.size())
	                  return i;
	          }
	      }
	      return -1;
	  }
	  
	  public static int solution4(int[] A){
		  return 0;
	  }
	
}
