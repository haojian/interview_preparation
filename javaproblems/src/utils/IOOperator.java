package utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class IOOperator {
	private static IOOperator singleton;
	private FileWriter writer;
	public String writeToFilePath;
	private BufferedWriter out;
	
	public IOOperator(){
		writeToFilePath = "";
	}
	
	public static IOOperator getInstance() {
		if (singleton == null)
			singleton = new IOOperator();
		return singleton;
	}
	
	public void closeStream(){
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeToFile(String filename, String content, boolean isappend){
		try {
			writer = new FileWriter(filename, isappend);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeToFileUTF8(String filename, String content, boolean isappend){
		try {
			 out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename, isappend), "UTF-8"));
			
			 out.write(content);
			 out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
