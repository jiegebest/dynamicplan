package dp.依赖前一个状态.状态机.股票买卖;

public class S188买卖股票的最佳时机IV {

	public int maxProfit(int k, int[] prices) {
		int m = prices.length, n = k * 2;
		if (m == 0 || n == 0) {
			return 0;
		}
		int[][] f = new int[m][n + 1];
		for (int j = 1; j < n; j += 2) {
			f[0][j] = -prices[0];
		}
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j <= n; j += 2) {
				f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - 1] - prices[i]);
			}
			for (int j = 2; j <= n; j += 2) {
				f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - 1] + prices[i]);
			}
		}
		return f[m - 1][n];
	}

}
