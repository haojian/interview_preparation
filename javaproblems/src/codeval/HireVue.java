package codeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class HireVue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				File file = new File(args[0]);
				
				BufferedReader in;
				try {
					in = new BufferedReader(new FileReader(file));
					String line;
					String output;
					while ((line = in.readLine()) != null) {
				        //Process line of input Here
						output = ProcessLine(line);
						if(output != null)
							System.out.println(output);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				//String line = "10011011001;0110,1001,1001,0,10,11";
				//System.out.println(ProcessLine(line));
	}

	
	public static String ProcessLine(String line){
		String[] lists = line.split(" ");
		if(lists == null || lists.length == 0)
			return null;
		int ti = Integer.valueOf(lists[lists.length-1]);
		if(ti>=0 && ti<= lists.length){
			return lists[lists.length-1-ti];
		}
		return null;
	}
	
}
