package predict;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileCpy {

	/**
	 * Since we assume the input will be valid, I didn't do data validation in this program, which is easy to add in the future.
	 * 
	 * Test cases:
	 * 	duplicate data files in one line.
	 * 	empty line.
	 *  boundary dataset id value
	 *  line# = 0.
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			int n =Integer.parseInt(line);
			FileCpy  fc= new FileCpy();
			int i=0;
			while( i<n && (line = br.readLine()) != null){
				i++;
				fc.processLine(line, i);
			}
			fc.copyFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}

	private Map<String, Integer> filemap;	//store all the unique DataSet names
	private Map<Integer, Map<String, Integer>> dcentermap;		//store the existing files on different Data Center. HashMap for O(1) lookup operation.
	
	public FileCpy(){
		filemap = new HashMap<String, Integer>();
		dcentermap = new HashMap<Integer, Map<String, Integer>>();
	}
	
	//update value in the two maps.
	public void processLine(String line, int n){
		String[] files = line.split(" ");
		dcentermap.put(n, new HashMap<String, Integer>());
		for(int i=1; i<files.length;i++){
			if(!filemap.containsKey(files[i]))
				filemap.put(files[i], n);
			dcentermap.get(n).put(files[i], 0);
		}
	}
	
	//traverse all the data center to check if any file is missing.
	public void copyFile(){
		for(Map.Entry<Integer, Map<String, Integer>> dCenter: dcentermap.entrySet()){
			for(Map.Entry<String, Integer> entry:filemap.entrySet()){
				if(!dCenter.getValue().containsKey(entry.getKey())){
					System.out.println(entry.getKey() +" " + entry.getValue() + " " + dCenter.getKey());
				}
			}
		}
		System.out.println("done");
	}
}
