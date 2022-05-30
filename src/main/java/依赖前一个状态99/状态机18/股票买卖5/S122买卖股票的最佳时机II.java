package 依赖前一个状态99.状态机18.股票买卖5;

/**
 * 1-持有
 * 2-未持有
 */
public class S122买卖股票的最佳时机II {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] f = new int[n][2];
		f[0][0] = -prices[0];

		for (int i = 1; i < n; ++i) {
			f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] - prices[i]);
			f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] + prices[i]);
		}
		return f[n - 1][1];
	}

}
