package dp.依赖前一个状态.状态机.股票买卖;

/**
 * 因为可以同一天买卖，因此可以短区间计算利润，然后加和总利润
 * f-持有状态
 * g-未持有状态
 */
public class S122买卖股票的最佳时机II {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[] f = new int[n];
		int[] g = new int[n];
		f[0] = -prices[0];
		g[0] = 0;
		for (int i = 1; i < n; ++i) {
			f[i] = Math.max(f[i - 1], g[i - 1] - prices[i]);
			g[i] = Math.max(g[i - 1], f[i - 1] + prices[i]);
		}
		return g[n - 1];
	}

}
