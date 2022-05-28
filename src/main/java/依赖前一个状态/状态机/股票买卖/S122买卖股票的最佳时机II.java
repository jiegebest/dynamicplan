package 依赖前一个状态.状态机.股票买卖;

/**
 * 1-持有
 * 2-未持有
 */
public class S122买卖股票的最佳时机II {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] f = new int[n][3];
		f[0][1] = -prices[0];

		for (int i = 1; i < n; ++i) {
			f[i][1] = Math.max(f[i - 1][1], f[i - 1][2] - prices[i]);
			f[i][2] = Math.max(f[i - 1][2], f[i - 1][1] + prices[i]);
		}

		return f[n - 1][2];
	}

}
