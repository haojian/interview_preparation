package application;

import java.sql.Date;
import java.util.Map;

public class datediff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	//
	public static void find(char[][] matrix, Map<String, PosPuzzle> dict){
	    //check...
	    int r = matrix.length;
	    int c = matrix[0].length;
	    for(int i=0; i<r; i++){
	      for(int j=0; j<c; j++){
	        for(Map.Entry<String, PosPuzzle> entry : dict.entrySet()){
	              int dir = -1;
	              if((dir = search(matrix, i, j, entry.getKey()))>=0)
	                dict.put(entry.getKey(), new PosPuzzle(i, j, dir));
	          }
	        }
	      }
	  }
	  
	public static int search(char[][] matrix, int ri, int ci, String word){
	    int[][] directions = {{0,1}, {1, 0}, {0,-1},{-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
	    int offset = 0;
	     int r = matrix.length;
	    int c = matrix[0].length;
	    for(int di = 0; di<8; di++){
	      for(offset = 0; offset < word.length(); offset++){
	        int offsetx = directions[di][0]*offset;
	        int offsety = directions[di][1]*offset;
	        if(ri+offsetx >=0 && ri+offsetx <r && ci+offsety >=0 && ci+offsety <c && matrix[ri+offsetx ][ci+offsety ] != word.charAt(offset)){
	            break;
	          }
	     }
	     if(offset == word.length())
	       return di;
	    }
	    return -1;
	}
}

class PosPuzzle{
    int startx;
    int starty;
    int direction;
    PosPuzzle( int startx,
    int starty,
    int direction){
      
      }
  }

