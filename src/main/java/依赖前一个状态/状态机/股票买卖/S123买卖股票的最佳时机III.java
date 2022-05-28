package 依赖前一个状态.状态机.股票买卖;

public class S123买卖股票的最佳时机III {

	/**
	 未操作 < 未操作 收益为0，不用记录.因为买入时机可以在任何时候开始，并且利润最小也是0，所以维护未操作状态无意义
	 买第一次 < 买第一次 / 未操作
	 完成第一次交易 < 完成第一次交易 / 买第一次
	 买第二次 < 买第二次 / 完成第一次交易
	 完成第二次交易 < 完成第二次交易 / 买第二次

	 1-第一次持有，2-第一次交易完成，3-第二次持有，4-第二次交易完成
	 f[0][2] = -prices[0]; 代表的意思是只进行一次交易。
	 */
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] f = new int[2][5];
		f[0][1] = f[0][3] = -prices[0];

		for (int i = 1; i < n; ++i) {
			int curr = i % 2, prev = (i - 1) % 2;
			f[curr][1] = Math.max(f[prev][1], f[prev][0] - prices[i]);
			f[curr][2] = Math.max(f[prev][2], f[prev][1] + prices[i]);
			f[curr][3] = Math.max(f[prev][3], f[prev][2] - prices[i]);
			f[curr][4] = Math.max(f[prev][4], f[prev][3] + prices[i]);
		}

		return f[(n - 1) % 2][4];
	}

}
