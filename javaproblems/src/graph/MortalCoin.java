package graph;

import java.util.Random;

public class MortalCoin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width = 10;
		int blockedPointCounter = 2; 
		int[][] boarder = new int[width][width];
		Random rdm = new Random();
		while(blockedPointCounter > 0){
			int randomPointX = rdm.nextInt(width);
			int randomPointY = rdm.nextInt(width);
			if(boarder[randomPointX][randomPointY] == 0){
				boarder[randomPointX][randomPointY] = 1;
				blockedPointCounter--;
			}
		}
		//exploreSolutionRecursive
	}
	
	public static void exploreSolutionRecursive(int completeGridCounter, int[][] boarder){
		//if(completeGridCounter == boarder.length * boarder.length)
	}
	
	public static boolean ifComplete(int[][] boarder){
		return false;
	}
}
