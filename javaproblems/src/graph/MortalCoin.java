package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class MortalCoin {
	 private static int[][] offsets = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; 
	    private static char[] offNames = {'L', 'D', 'R', 'U'}; 
	    private Random r = new Random(); 
	    private static String name, pw; 
	    private int targetFill, boardX, boardY, startX = -1, startY = -1, board[][]; 
	    private String boardString; 

	    public static void main(String[] args) throws Exception { 

	        name = "haojian"; pw = "haojian"; 
	        MortalCoin mcs = new MortalCoin(); 
	        while (true) { 
	            mcs.go(); 
	            Thread.sleep(2000); 
	        } 
	    } 

	    private void go() throws Exception { 
	        URL u; 
	        u = new URL("http://www.hacker.org/coil/index.php?name=" + name + "&password=" + pw); 
	        System.out.println("http://www.hacker.org/coil/index.php?name=" + name + "&password=" + pw); 
	        InputStream is = u.openStream(); 
	        input2level(is); 
	        System.out.println(this); 
	        SolveCoil();
	    } 

	    public String toString() { 
	        String s = ""; 
	        for (int j = 0; j < boardY; j++) {
	            for (int i = 0; i < boardX; i++) { 
	                s += board[i][j] > 0 ? 'X' : '.'; 
	            } 
	            if (j < boardY - 1) s += '\n'; 
	        } 
	        return s; 
	    } 

	    
	    public void SolveCoil(){
	    	parseBoardString();
	    	for(int x=0; x<boardX; x++){
	    		for(int y=0; y<boardY; y++){
	    			if(board[x][y]!=0)
	    				continue;
	    			board[x][y] =1;
	    			ArrayList<Character> pathlist = new ArrayList<Character>();
	    			if(SolveRecur(x, y, 1, pathlist)) {
	    				String path = "";
	    				for(Character ch : pathlist)
	    					path+= ch;
	    				System.out.println("solved at (" + x + ", " + y + ") : " + path);
	    				URL u; 
	    		        try {
							u = new URL("http://www.hacker.org/coil/index.php?name=" + name + 
							        "&password=" + pw + "&path=" + path + "&x=" + x + "&y=" + y);
	    		        InputStream is = u.openStream(); 
	    		        BufferedReader in = new BufferedReader(new InputStreamReader(is));
	    		        while ((in.readLine()) != null) { } 
	    		        	is.close(); 
	    		        }
	    		        catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
	    				return;
	    			}
	    			board[x][y] =0;
	    		}
	    	}
	    	System.out.println("failed");
	    }
	    
	    public boolean SolveRecur(int x, int y, int filledCounter, ArrayList<Character> pathlist){
	    	if(filledCounter == targetFill) 
	    		return true;
	    	for(int i=0; i<4; i++){
	    		int offx = offsets[i][0]; 
                int offy = offsets[i][1];
                if(x+offx >=0 && x+offx <boardX && y+offy >=0 && offy+y <boardY &&  board[x+offx][y+offy] ==0  ){
                	//update value
                	pathlist.add(offNames[i]);
                	int counter = 0;
                	 while (board[x+offx][y+offy] == 0) { // move until we hit something 
                         x += offx; y += offy;
                         board[x][y] = 2;
                         filledCounter++;
                         counter++;
                         if(x+offx < 0 || x+offx >= boardX ||  y+offy >= boardY || y+offy<0 ||  board[x+offx][y+offy] !=0)
                         	break;
                     }
                	 if(SolveRecur(x, y, filledCounter, pathlist)) return true;
                 	pathlist.remove(pathlist.size()-1);
                	while(counter>0){
                		board[x][y] = 0;
                    	 x -= offx; y -= offy;
                
                         filledCounter--;
                         counter--;
                    }
                }
	    	}
	    	return false;
	    }
	    
	    private void input2level(InputStream is) throws IOException { 
	        BufferedReader in = new BufferedReader(new InputStreamReader(is));
	        String line; 
	        while ((line = in.readLine()) != null) { 
	            if (!line.contains("<param name=\"FlashVars\"")) continue; 
	            line = line.split("\"")[3]; // get just the value 
	            String[] ss = line.split("(=|&)"); // split up the name value pairs 
	            boardX = Integer.parseInt(ss[1]); boardY = Integer.parseInt(ss[3]); 
	            board = new int[boardX][boardY]; 
	            boardString = ss[5]; 
	            parseBoardString(); 
	        } 
	        in.close(); 
	    } 

	    private void parseBoardString() { 
	        int cnt = 0; 
	        for (int x = 0; x < boardX; x++) 
	            for (int y = 0; y < boardY; y++) { 
	                int a = boardString.charAt(x + y * boardX) == 'X' ? 1 : 0;
	                board[x][y] = a; 
	                cnt += a; 
	            } 
	        targetFill = (boardX * boardY) - cnt; // how many squares we need to fill 
	    } 
}
