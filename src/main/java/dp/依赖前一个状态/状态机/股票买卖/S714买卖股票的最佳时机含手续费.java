package dp.依赖前一个状态.状态机.股票买卖;

/**
 * 0-   持有
 * 1-不持有
 */
public class S714买卖股票的最佳时机含手续费 {

	public int maxProfit(int[] prices, int fee) {
		int n = prices.length;
		int[] f = new int[n];
		int[] g = new int[n];
		f[0] = -prices[0];
		for (int i = 1; i < n; ++i) {
			f[i] = Math.max(f[i - 1], g[i - 1] - prices[i]);
			g[i] = Math.max(g[i - 1], f[i - 1] + prices[i] - fee);
		}
		return g[n - 1];
	}

}
