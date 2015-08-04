package leetcode_final;

/*
 * Say you have an array
 * for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete at most two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 * 
 * Left[i] means for current day i, best buy and sell value between 0~i;
 * right[i] means for current day i, best buy and sell value between i~length-1.
 */
public class BestTimeBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (prices.length < 2)
			return 0;
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];
		int minVal = prices[0];
		int maxVal = prices[prices.length - 1];
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			minVal = Math.min(minVal, prices[i]);
			left[i] = Math.max(left[i - 1], prices[i] - minVal);
		}
		for (int i = prices.length - 2; i >= 0; i--) {
			maxVal = Math.max(maxVal, prices[i]);
			right[i] = Math.max(right[i + 1], maxVal - prices[i]);
		}
		for (int i = 0; i < prices.length; i++) {
			res = Math.max(res, left[i] + right[i]);
		}
		return res;
	}
}
