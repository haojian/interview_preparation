package basic;

import java.util.HashMap;
import java.util.Map;

public class ArrayDifferences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 2, 3, 4, 5};
		int[] B = {2, 3, 1, 0, 5};
		OutputDifference(A, B);
	}
	
	public static void OutputDifference(int A[], int B[]){
		Map<Integer, Integer> record = new HashMap<Integer, Integer>();
		for(int tmp: A){
			record.put(tmp, 1);
		}
		for(int tmp:B){
			if(!record.containsKey(tmp)){
				System.out.println(tmp);
			}
		}
	}

}
