package dp.依赖前一个状态.状态机.股票买卖;

/**
 * 第一次买入，第一次卖出，第二次买入，第二次卖出
 * 一开始就进行第二次买入相当于只进行一次交易
 */
public class S123买卖股票的最佳时机III {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] f = new int[n][4];
		f[0][0] = f[0][2] = -prices[0];
		for (int i = 1; i < n; ++i) {
			f[i][0] = Math.max(f[i - 1][0], -prices[i]);
			f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] + prices[i]);
			f[i][2] = Math.max(f[i - 1][2], f[i - 1][1] - prices[i]);
			f[i][3] = Math.max(f[i - 1][3], f[i - 1][2] + prices[i]);
		}
		return f[n - 1][3];
	}

}
