package 依赖前一个状态.状态机.股票买卖;

public class S188买卖股票的最佳时机IV {

	public int maxProfit(int k, int[] prices) {
		int n = prices.length, m = 2 * k;
		if (n == 0 || k == 0) {
			return 0;
		}

		int[][] f = new int[2][m + 1];
		for (int j = 1; j <= m; j += 2) {
			f[0][j] = -prices[0];
		}

		for (int i = 1; i < n; ++i) {
			int prev = (i - 1) % 2, curr = i % 2;
			for (int j = 1; j <= m; j += 2) {
				f[curr][j] = Math.max(f[prev][j], f[prev][j - 1] - prices[i]);
			}
			for (int j = 2; j <= m; j += 2) {
				f[curr][j] = Math.max(f[prev][j], f[prev][j - 1] + prices[i]);
			}
		}

		return f[(n - 1) % 2][m];
	}

}
