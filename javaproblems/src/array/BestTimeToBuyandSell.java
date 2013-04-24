package array;

public class BestTimeToBuyandSell {

	/**
	 * 
	 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {2, 1};
		System.out.println(maxProfit(prices));
	}

    public static int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices==null || prices.length == 0)
            return 0;
        int[] leftLowest = new int[prices.length];
        int minleft = prices[0];
        leftLowest[0] = prices[0];
        for(int i=1; i<prices.length; i++){
            if(minleft > prices[i])
                minleft = prices[i];
            leftLowest[i] = minleft;
        }
        int max = 0;
        for(int i=prices.length-1; i>=0; i--){
            int curmax = prices[i] - leftLowest[i];
            if(curmax>max)
                max = curmax;
        }
        return max;
    }
}
