package graph.advance;

import java.util.Stack;

public class LargestRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2, 1, 5, 6, 2 ,3};
		System.out.println(largestRectangleAreav2(input));
	}
	
	//first calculate the left boundary possibilities then the right boundary possibilities
	public static int largestRectangleAreav2(int[] height){
		if(height == null || height.length == 0)
			return 0;
		Stack<Integer> hs = new Stack<Integer>();
		int res = 0;
		for(int i=0; i<height.length; i++){
			if(hs.isEmpty() || hs.peek() <= height[i]){
				hs.push(height[i]);
			}else{
				int counter = 0;
				while(!hs.isEmpty() && hs.peek() >height[i]){
					counter ++;
					int top = hs.pop();
					res = Math.max(res, top*counter);
				}
				while(counter>=0){
					hs.push(height[i]);
					counter--;
				}
			}
		}
		int counter = 0;
		while(!hs.isEmpty()){
			counter++;
			int top = hs.pop();
			res = Math.max(res, top*counter);
		}
		return res;
	}
	
	public static int largestRectangleAreav1(int[] height){
		if(height == null|| height.length == 0)
			return 0;
		Stack<Integer> hs = new Stack<Integer>();
		int res = 0;
		for(int i=0; i<height.length; i++){
			if(hs.isEmpty() || hs.peek() <= height[i]){
				hs.push(height[i]);
			}else{
				int counter = 0;
				while(!hs.isEmpty() && hs.peek() >height[i]){
					counter++;
					int top = hs.pop();
					res = Math.max(res, top * counter);

				}
				
				for(int j=0; j<counter;j++)
				{
					hs.push(height[i]);
				}
			}
		}
		return res;
	}
	
	public static int largestRectangleArea(int[] height){
		if(height == null || height.length == 0)
			return 0;
		Stack<Integer> hs = new Stack<Integer>();
		hs.push(height[0]);
		int res = 0;
		for(int i=1; i<height.length; i++){
			if(hs.isEmpty())
				break;
			if(hs.peek() < height[i])
				hs.push(height[i]);
			else{
				int counter = 0;
				while(!hs.isEmpty() && hs.peek() > height[i]){
					hs.pop();
					counter ++;
				}
				while(counter >=0)
					hs.push(height[i]);
				res = Math.max(res, counter*height[i]);
			}
		}
		return res;
	}
}
