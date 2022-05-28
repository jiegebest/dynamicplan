package 依赖前一个状态.状态机.股票买卖;

/**
 * 0-持有
 * 1-冷冻
 * 2-未持有未冷冻
 */
public class S309最佳买卖股票时机含冷冻期 {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] f = new int[2][3];
		f[0][0] = -prices[0];

		for (int i = 1; i < n; ++i) {
			int prev = (i - 1) % 2, curr = i % 2;
			f[curr][0] = Math.max(f[prev][0], f[prev][2] - prices[i]);
			f[curr][1] = f[prev][0] + prices[i];
			f[curr][2] = Math.max(f[prev][1], f[prev][2]);
		}

		return Math.max(f[(n - 1) % 2][1], f[(n - 1) % 2][2]);
	}

}
