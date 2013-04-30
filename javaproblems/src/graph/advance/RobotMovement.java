package graph.advance;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotMovement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RobotMovement(4);
	}

	static int[][] directions = {{0,1},{0,-1}, {1,0}, {-1, 0}};
	
	public static int RobotMovement(int N){
		boolean[][] grids = new boolean[N][N];
		grids[0][0] = true;
		 HashSet<ArrayList<Integer>> uniquePaths = new  HashSet<ArrayList<Integer>>();
		ArrayList<Integer> trace = new ArrayList<Integer>();
		MoveRecur(grids, trace, uniquePaths, 0, 0);
		System.out.println(uniquePaths.size());
		return 0;
	}
	
	public static void MoveRecur(boolean[][] grids, ArrayList<Integer> curTrace,  HashSet<ArrayList<Integer>> uniquePaths, int curX, int curY){
		if(curX == grids.length-1 && curY == grids.length-1){
			ArrayList<Integer> tmp = (ArrayList<Integer>)curTrace.clone();
			uniquePaths.add(tmp);
		}
		else{
			for(int i=0;i<4;i++){
				curX += directions[i][0];
				curY += directions[i][1];
				if(curX<0 || curX>= grids.length || curY<0 || curY>=grids.length || grids[curX][curY]){
					curX -= directions[i][0];
					curY -= directions[i][1];
					continue;
				}
				grids[curX][curY] = true;
				curTrace.add(i);
				MoveRecur(grids, curTrace, uniquePaths, curX, curY);
				curTrace.remove(curTrace.size()-1);
				grids[curX][curY] = false;
				curX -= directions[i][0];
				curY -= directions[i][1];
			}
		}
	}
}
