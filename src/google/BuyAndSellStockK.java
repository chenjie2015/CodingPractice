package google;

public class BuyAndSellStockK {
	public int maxProfit(int[] prices, int k) {
		if (prices == null || prices.length == 0)
			return 0;
		int len = prices.length;
		int[][][] dp = new int[len][len][k];
		initialize(dp, prices);
		// dp[i][j][k] = for each i < m < j, max(dp[i][m][k - 1] + dp[m][j][0])

		for (int s = 1; s < k; s++) {
			for (int i = 0; i < len; i++) {
				for (int j = i + 1; j < len; j++) {
					int max = 0;
					for(int m = i + 1; m < j; m++){
						if(dp[i][m][s - 1] + dp[m][j][0] >  max)
							max = dp[i][m][s - 1] + dp[m][j][0];
					}
					dp[i][j][s - 1] = max;
				}
			}
		}
		return dp[0][len - 1][k - 1];
	}

	public void initialize(int[][][] dp, int[] prices) {
		int len = prices.length;
		for (int i = 0; i < len; i++) {
			int min = prices[i];
			int profit = 0;
			for (int j = i + 1; j < len; j++) {
				if (prices[j] - min >= profit)
					profit = prices[j] - min;
				dp[i][j][0] = profit;
				if (prices[j] < min)
					min = prices[j];
			}
		}
	}
	
	public int maxProfitImproved(int[] prices, int k) {
		if (prices == null || prices.length == 0)
			return 0;
		int len = prices.length;
		int[][] dp = new int[len][len];
		initializeImproved(dp, prices);

		int[] k_1Sum = new int[len];
		int[] kSum = new int[len];

		for (int s = 1; s < k; s++) {
			for (int j = 1; j < len; j++) {
				int max = 0;
				for(int m = 1; m < j; m++){
					if(k_1Sum[m] + dp[m][j] >  max)
						max = k_1Sum[m] + dp[m][j];
				}
				kSum[j] = max;
			}
			int[] temp = k_1Sum;
			k_1Sum = kSum;
			kSum = temp;
		}
		return k_1Sum[len];
	}
	
	public void initializeImproved(int[][] dp, int[] prices) {
		int len = prices.length;
		for (int i = 0; i < len; i++) {
			int min = prices[i];
			int profit = 0;
			for (int j = i + 1; j < len; j++) {
				if (prices[j] - min >= profit)
					profit = prices[j] - min;
				dp[i][j] = profit;
				if (prices[j] < min)
					min = prices[j];
			}
		}
	}
}
