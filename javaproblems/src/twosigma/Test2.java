package twosigma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			int n =Integer.parseInt(line);
			Test2  tmp= new Test2();
			int i=0;
			while((line = br.readLine()) != null){
				i++;
				tmp.processLine(line, i);
				if(i>=n)
					break;
			}
			tmp.copyFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}

	private Map<String, Integer> filemap;
	private ArrayList<String> cmds;
	
	public Test2(){
		filemap = new HashMap<String, Integer>();
		cmds = new ArrayList<String>();
	}
	
	public void processLine(String line, int n){
		String[] files = line.split(" ");
		for(String file: files){
			if(!filemap.containsKey(file)){
				filemap.put(file, n);
			}
		}
		cmds.add(line);
	}
	
	public void copyFile(){
		for(int i=0; i<cmds.size(); i++){
			for(Map.Entry<String, Integer> entry:filemap.entrySet()){
				if(!cmds.get(i).contains(entry.getKey())){
					System.out.println(entry.getKey() +" " + entry.getValue() + " " + (i+1));
				}
			}
		}
		System.out.println("done");
	}
}
