package twosigma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] input = {"car", "truck", "bus"};
		//Integer b = Integer.valueOf("10a");
		//Integer.parseInt("230");
		String[] input = {Integer.toString(Integer.MAX_VALUE), Integer.toString(Integer.MIN_VALUE), "car", "truck", "-8", "4", "bus", "6", "1"};
		sort(Arrays.asList(input));
		//Arrays.sort(input);
		//System.out.println(Arrays.toString(input));
		
	}
	
    public static java.util.List<String> sort(java.util.List<String> input){
    	List<String> res = new ArrayList<String>();
    	if(input==null || input.size() == 0)
    		return res;
    	ArrayList<Integer> numbers = new ArrayList<Integer>();
    	ArrayList<String> words = new ArrayList<String>();
    	boolean[] flag = new boolean[input.size()];
    	System.out.println("input: " +input);
    	for(int i=0; i<input.size(); i++){
    		try {
    		    int num = Integer.parseInt(input.get(i));
    		    numbers.add(num);
    		    flag[i] = true;
    		} catch(NumberFormatException e) {
    			words.add(input.get(i));
    		}
    	}
    	System.out.println("num: " +numbers);
    	System.out.println("words: " +words);
    	Collections.sort(numbers);
    	Collections.sort(words);
    	int numi=0;
    	int wordi=0;
    	for(int i=0; i<input.size(); i++){
    		if(flag[i]){
    			res.add(Integer.toString(numbers.get(numi)));
    			numi++;
    		}else{
    			res.add(words.get(wordi));
    			wordi++;
    		}
    	}
    	System.out.println("num: " +numbers);
    	System.out.println("words: " +words);
    	System.out.println("res: " +res);
		return res;
    	
    }

}
