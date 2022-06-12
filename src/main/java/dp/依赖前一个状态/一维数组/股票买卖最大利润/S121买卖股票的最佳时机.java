package dp.依赖前一个状态.一维数组.股票买卖最大利润;

public class S121买卖股票的最佳时机 {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[] f = new int[n];
		f[0] = 0;

		int min = prices[0], max = 0;
		for (int i = 1; i < n; ++i) {
			min = Math.min(min, prices[i]);
			f[i] = prices[i] - min;
			max = Math.max(max, f[i]);
		}
		return max;
	}

}
