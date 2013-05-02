package array;

public class BestTimeToBuyandSell3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2,1,2,0,1};
		System.out.println(maxProfit(input));
	}
	
    public static int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(prices == null || prices.length == 0)
    		return 0;
    	int[] maxPl2r =  new int[prices.length];
    	int[] tmp = new int[prices.length];
    	maxPl2r[0] = 0;
    	int min = prices[0];
    	int maxLeftProfit = 0;
    	for(int i=1;i<prices.length; i++){
    		int curProfit = prices[i]-min;
    		maxLeftProfit = Math.max(maxLeftProfit, curProfit);
    		maxPl2r[i] = maxLeftProfit;
    		min = Math.min(min, prices[i]);
    	}
    	int max = prices[prices.length-1];
    	int maxRightProfit = 0;
    	int res = 0;
    	for(int i=prices.length-2; i>=0; i--){
    		int curProfit = max-prices[i];
    		maxRightProfit = Math.max(maxRightProfit, curProfit);
    		res = Math.max(res, maxRightProfit+maxPl2r[i]);
    	    max = Math.max(max, prices[i]);
    	}
    	return res;
    }
}
