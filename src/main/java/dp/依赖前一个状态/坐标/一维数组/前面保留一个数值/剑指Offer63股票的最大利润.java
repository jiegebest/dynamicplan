package dp.依赖前一个状态.坐标.一维数组.前面保留一个数值;

public class 剑指Offer63股票的最大利润 {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[] f = new int[n];
		f[0] = 0;

		int min = prices[0], max = 0;
		for (int i = 1; i < n; ++i) {
			f[i] = prices[i] - min;
			max = Math.max(max, f[i]);
			min = Math.min(min, prices[i]);
		}
		return max;
	}

}
