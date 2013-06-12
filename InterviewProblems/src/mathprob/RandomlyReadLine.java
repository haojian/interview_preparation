package mathprob;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

public class RandomlyReadLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String randLine(String path){
		String res = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = "";
			Random rand = new Random();
			int counter = 0;
			while((line = br.readLine()) != null){
				if(rand.nextInt(counter+1) == 0 )
					res = line;
				counter++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	
}
