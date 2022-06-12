package dp.依赖前一个状态.一维数组.等差数列;

import java.util.Arrays;

/**
 * 等差数列
 * 要求连续
 */
public class S2110股票平滑下跌阶段的数目 {

	public long getDescentPeriods(int[] prices) {
		int n = prices.length;
		int[] f = new int[n];
		Arrays.fill(f, 1);

		for (int i = 1; i < n; ++i) {
			if (prices[i - 1] - prices[i] == 1) {
				f[i] += f[i - 1];
			}
		}

		long total = 0;
		for (int cnt : f) {
			total += cnt;
		}
		return total;
	}

}
