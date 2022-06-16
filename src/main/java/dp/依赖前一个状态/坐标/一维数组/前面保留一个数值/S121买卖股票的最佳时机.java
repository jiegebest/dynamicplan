package dp.依赖前一个状态.坐标.一维数组.前面保留一个数值;

public class S121买卖股票的最佳时机 {

	public int maxProfit(int[] prices) {
		int maxProfit = 0, minPrice = prices[0], n = prices.length;
		for (int i = 1; i < n; ++i) {
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
			minPrice = Math.min(minPrice, prices[i]);
		}
		return maxProfit;
	}

}
