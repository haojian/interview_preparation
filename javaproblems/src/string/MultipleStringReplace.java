package string;

import java.util.ArrayList;
import java.util.Arrays;

public class MultipleStringReplace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line = "10011011001;0110,1001,1001,0,10,11";
		System.out.println(ProcessLine(line));
	}
	
	public static String ProcessLine(String line){
		String[] parts = line.split(";");
		String[] tmps = parts[1].split(",");
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
	
	public static String MultipleStringReplace(String input, String[] original, String[] replacements)
	{
		String res = input;
		if(original.length != replacements.length)
			return null;
		boolean hash[] = new boolean[input.length()];
		Arrays.fill(hash, false);
		boolean replaceTracker[] = new boolean[original.length];
		Arrays.fill(replaceTracker, false);
		for(int i =0; i<original.length; i++){
			int si = input.indexOf(original[i]);
			boolean ifreplace = true;
			if(si != -1){
				for(int j=si; j<original[i].length(); j++){
					if(hash[j] == true){
						ifreplace = false;
						break;
					}
				}
				if(ifreplace){
					replaceTracker[i] = true;
					//update hash
					for(int j=si; j<original[i].length(); j++){
						hash[j] = true;
					}
				}
			}
		}
		for(int i = 0 ; i<replaceTracker.length; i++)
		{
			if(replaceTracker[i])
				res = res.replace(original[i], replacements[i]);
		}	
		return res;
	}

}
