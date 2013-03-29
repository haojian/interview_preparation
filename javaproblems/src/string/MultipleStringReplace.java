package string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MultipleStringReplace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		File file = new File(args[0]);
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
		        //Process line of input Here
				System.out.println(ProcessLine(line));
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
		String line = "10011010001011000111000111111110000010101011011011000101100010000111001;011001,1111,110,1011,1011,11";
		//String line = "1111101011;011001,1111,110,1011,1011,11";
		//String line = "10011011001;0110,1001,1001,0,10,11";
		System.out.println(ProcessLine(line));
		
	}
	
	public static String ProcessLine(String line){
		String[] parts = line.split(";");
		String[] tmps = parts[1].split(",");
		System.out.println(parts[0].length());
		if(tmps.length%2==1)
			return null;
		String[] originals = new String[tmps.length/2];
		String[] replacements = new String[tmps.length/2];
		for(int i = 0; i<tmps.length; i++){
			if(i%2 == 1){
				replacements[i/2] = tmps[i];
			}else{
				originals[i/2] = tmps[i];
			}
		}
		return MultipleStringReplace(parts[0], originals, replacements);
	}
	
	public static String MultipleStringReplace(String input, String[] original, String[] replacements){
		if(original.length != replacements.length)
			return null;
		char[] res = input.toCharArray();
		boolean[] hash = new boolean[input.length()];
		int resIndexTracker = 0;
		Map<Integer, String> stringMap = new HashMap<Integer, String>();
		for(int i = 0; i <original.length; i++){
			int si = 0;
			while((si = input.indexOf(original[i], si)) != -1){
				boolean ifreplace =true;
				for(int j = 0; j< original[i].length(); j++){
					if(hash[j+si] == true){
						ifreplace = false;
						break;
					}
				}
				if(ifreplace){
					for(int j = 0; j< original[i].length(); j++){
						hash[j+si] = true;
						if(j<replacements[i].length())
							res[j+si] = replacements[i].charAt(j);
						else{
							res[j+si] = ' ';
						}
					}
					if(replacements[i].length() > original[i].length()){
						stringMap.put(original[i].length()+si-1, replacements[i].substring(original[i].length()));
					}
				}
				si++;
			}
		}
		char[] returnres = new char[input.length() * 2];
		int resIndex = 0;
		for(int i = 0 ; i<res.length; i++){
			if(res[i] == ' ')
				continue;
			returnres[resIndex] = res[i];
			resIndex++;
			if(stringMap.containsKey(i)){
				for(int j=0; j<stringMap.get(i).length(); j++){
					returnres[resIndex] = stringMap.get(i).charAt(j);
					resIndex++;
				}
			}
		}
		
		String str = new String(returnres);
		System.out.println(str.trim().length());
		return str.trim();
		
	}

}
