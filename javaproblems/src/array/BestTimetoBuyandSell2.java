package array;

import java.util.HashMap;
import java.util.Map;

public class BestTimetoBuyandSell2 {

	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {2, 4, 1};
		System.out.println(maxProfit(prices));
	}

    public static int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(prices == null || prices.length == 0)
    		return 0;
    	Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
    	return maxProfitBruteForceDP(prices, prices.length, hash);
    }
    
    
    public static int maxProfitBruteForce(int[] prices, int ei){
    	if(ei<=1)
    		return 0;
    	if(ei == 2)
    		return Math.max(0, prices[1] - prices[0]);
    	int max = 0;
    	for(int i=0; i< ei; i++)
    	{
    		int lastSum = prices[ei-1]-prices[i];
    		lastSum = lastSum>0?lastSum:0;
    		if(ei-1<i)
    			lastSum = 0;
    		
    		max = Math.max(max, maxProfitBruteForce(prices, i)+ lastSum);
    	}
    	return max;
    }
    
    
    public static int maxProfitBruteForceDP(int[] prices, int ei, Map<Integer, Integer> hash){
    	if(ei<=1)
    		return 0;
    	if(ei == 2)
    		return Math.max(0, prices[1] - prices[0]);
    	int max = 0;
    	if(hash.containsKey(ei))
    		return hash.get(ei);
    	for(int i=0; i< ei; i++)
    	{
    		int lastSum = prices[ei-1]-prices[i];
    		lastSum = lastSum>0?lastSum:0;
    		if(ei-1<i)
    			lastSum = 0;
    		
    		max = Math.max(max, maxProfitBruteForceDP(prices, i, hash)+ lastSum);
    	}
    	if(!hash.containsKey(ei))
    		hash.put(ei, max);
    	return max;
    }
}
