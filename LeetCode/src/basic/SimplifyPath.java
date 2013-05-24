package basic;

import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;

public class SimplifyPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
	}
	
    public static String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	Stack<String> stack = new Stack<String>();
        path = path.trim();
        String[] dirs = path.split("[/]");
        int emptyCounter = 0;
        for(int i=0; i<dirs.length; i++){
        	if(dirs[i].isEmpty() || dirs[i].equals("."))
        		continue;
        	if(dirs[i].equals("..")){
        		if(stack.isEmpty()){
        			emptyCounter--;
        		}else
        			stack.pop();
        	}else{
        		/*
        		if(emptyCounter < 0){
        			emptyCounter++;
        		}else*/
        		{
        			stack.push(dirs[i]);
        		}
        	}
        }
        ArrayList<String> list = new ArrayList<String>(stack);
        String res = "";

        for(String x:list){
        	res+= "/"+x;
        }
        if(res.length() == 0)
        	return "/";
        return res;
    }
}
