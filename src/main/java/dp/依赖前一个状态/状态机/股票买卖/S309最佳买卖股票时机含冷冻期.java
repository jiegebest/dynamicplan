package dp.依赖前一个状态.状态机.股票买卖;

/**
 * 未持有
 * 持有
 * 卖出
 * 冷冻期
 * f[i] 表示第 i 天结束的最大收益
 */
public class S309最佳买卖股票时机含冷冻期 {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] f = new int[n][4];
		f[0][1] = -prices[0];
		for (int i = 1; i < n; ++i) {
			f[i][0] = Math.max(f[i - 1][0], f[i - 1][3]);
			f[i][1] = Math.max(f[i - 1][1], Math.max(f[i - 1][0], f[i - 1][3]) - prices[i]);
			f[i][2] = f[i - 1][1] + prices[i];
			f[i][3] = f[i - 1][2];
		}
		return Math.max(f[n - 1][0], Math.max(f[n - 1][2], f[n - 1][3]));
	}

}