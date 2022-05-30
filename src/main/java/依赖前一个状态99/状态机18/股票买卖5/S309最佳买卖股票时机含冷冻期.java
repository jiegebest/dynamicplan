package 依赖前一个状态99.状态机18.股票买卖5;

/**
 * 0-持有
 * 1-冷冻
 * 2-未持有未冷冻
 */
public class S309最佳买卖股票时机含冷冻期 {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] f = new int[n][3];
		f[0][0] = -prices[0];

		for (int i = 1; i < n; ++i) {
			f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
			f[i][1] = f[i - 1][0] + prices[i];
			f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
		}
		return Math.max(f[n - 1][1], f[n - 1][2]);
	}

}