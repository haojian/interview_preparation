package graph.advance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BoxTowers {

	/**
	 * Submission 1. failed for exceeding time limits.
	 *
	 * @param args
	 */
	 public static void main(String args[] ) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        BoxTowers bt = new BoxTowers();
	        bt.N = Integer.parseInt(line);
	        bt.boxes = new int[bt.N][3];
	        for (int i = 0; i < bt.N; i++) {
	        	line = br.readLine();
	        	String[] dimensions = line.split(" ");
	        	if(dimensions.length != 3)
	        		return;
	        	for(int j=0; j<3;j++){
	        		bt.boxes[i][j] = Integer.valueOf(dimensions[j]);
	        	}
	            
	        }
	        System.out.println(bt.bruteForcce());
	 }
	 
	 public int N = 0;
	 public int[][] boxes;
	 
	 public int bruteForcce(){
		 int[] max = new int[1];
		 max[0]=0;
		 ArrayList<Integer> usedBoxes = new ArrayList<Integer>();
		 buildTowerRecur(usedBoxes, Integer.MAX_VALUE, Integer.MAX_VALUE, 0,max);
		 return max[0];
	 }
	 
	 public void buildTowerRecur(ArrayList<Integer> usedBoxes, int maxWidth, int maxHeight, int curHeight, int[] max){
		 if(usedBoxes.size() == N){
			 return;
		 }
		 for(int i=0; i<N; i++){
			 //check if ith box is valid to add
			 if(usedBoxes.contains(i))
				 continue;
			 ArrayList<int[]> nextBoxOrientation = getNextBoxOrientation(i, maxWidth, maxHeight);
			 if(nextBoxOrientation == null || nextBoxOrientation.size() == 0)
				 continue;
			 usedBoxes.add(i);
			 for(int j=0; j<nextBoxOrientation.size(); j++){
				 int tmp =curHeight + nextBoxOrientation.get(j)[2];
				 if(max[0] < tmp)
					 max[0] = tmp;
				 buildTowerRecur(usedBoxes, nextBoxOrientation.get(j)[0], nextBoxOrientation.get(j)[1], tmp, max);
			 }
			 usedBoxes.remove(usedBoxes.size()-1);
		 }
	 }
	 
	 
	 public ArrayList<int[]> getNextBoxOrientation(int index, int maxWidth, int maxHeight){
		 ArrayList<int[]> res = new ArrayList<int[]>();
		 int[] dimensions = boxes[index];
		 for(int i=0; i<3; i++){
			 for(int j=0; j<3; j++){
				 if(i==j)
					 continue;
				 if(dimensions[i]<=maxWidth && dimensions[j] <= maxHeight){
					 int[] orientation = new int[3];
					 orientation[0] = dimensions[i];
					 orientation[1] = dimensions[j];
					 orientation[2] = dimensions[3-i-j];
					 res.add(orientation);
				 }
			 }
		 }
		 return res;
	 }
}
