package 依赖前一个状态99.状态机20.股票买卖5;

/**
 * 未操作 < 未操作 收益为0，不用记录.因为买入时机可以在任何时候开始，并且利润最小也是0，所以维护未操作状态无意义
 * 买第一次 < 买第一次 / 未操作
 * 完成第一次交易 < 完成第一次交易 / 买第一次
 * 买第二次 < 买第二次 / 完成第一次交易
 * 完成第二次交易 < 完成第二次交易 / 买第二次
 * 1-第一次持有，2-第一次交易完成，3-第二次持有，4-第二次交易完成
 * f[0][2] = -prices[0]; 代表的意思是只进行一次交易。
 */
public class S123买卖股票的最佳时机III {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] f = new int[n][4];
		f[0][0] = f[0][2] = -prices[0];

		for (int i = 1; i < n; ++i) {
			f[i][0] = Math.max(f[i - 1][0], - prices[i]);
			f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] + prices[i]);
			f[i][2] = Math.max(f[i - 1][2], f[i - 1][1] - prices[i]);
			f[i][3] = Math.max(f[i - 1][3], f[i - 1][2] + prices[i]);
		}
		return f[n - 1][3];
	}

}
