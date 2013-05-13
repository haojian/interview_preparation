package predict;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SpecialSort {

	/**
	 * Since we assume the input will be valid, 
	 * I didn't do data validation in this program, 
	 * which is easy to add in the future.
	 * 
	 * Test cases:
		car truck 8 4 bus 6 1
		car truck -999999 4 bus 6 999999     6  6   //illegal input. 
		car truck -999999 4 bus 6 999999 6 6
		-999999 
		dcar truck -81 -141 bus 623 100
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SpecialSort js = new SpecialSort();
		try {
			String line = br.readLine();
			ArrayList<String> res = js.processLine(line);
			StringBuilder output = new StringBuilder();
			for(String single: res){
				output.append(single);
				output.append(" ");
			}
			System.out.println(output.toString().trim());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	//Words will not contain spaces
	public ArrayList<String>  processLine(String line){
		if(line == null || line.length() == 0){
			return new ArrayList<String>();
		}
		String[] subStrs = line.split(" ");
		return sort(subStrs);
	}
	
	
	//split the input into two parts "words" + "numbers", and sort them independently. 
	//then merge them based on "boolean[] flag"
	public ArrayList<String> sort(String[] input){
		ArrayList<String> res = new ArrayList<String>();
		if(input == null || input.length == 0){
			return res;
		}
		ArrayList<Integer> numbers = new ArrayList<Integer>();
    	ArrayList<String> words = new ArrayList<String>();
    	boolean[] flag = new boolean[input.length];
    	for(int i=0; i<input.length; i++){
    		try {
    		    int num = Integer.parseInt(input[i]);
    		    numbers.add(num);
    		    flag[i] = true;
    		} catch(NumberFormatException e) {
    			words.add(input[i]);
    			flag[i] = false;
    		}
    	}
    	Collections.sort(numbers);
    	Collections.sort(words);
    	int numi=0;
    	int wordi=0;
    	for(int i=0; i<input.length; i++){
    		if(flag[i]){
    			res.add(Integer.toString(numbers.get(numi)));
    			numi++;
    		}else{
    			res.add(words.get(wordi));
    			wordi++;
    		}
    	}
		return res;
	}
}
