package 未分类;

public class S2110股票平滑下跌阶段的数目 {

	public long getDescentPeriods(int[] prices) {
		long ans = 1, last = 1;
		for (int i = 1; i < prices.length; ++i) {
			int cur = prices[i];
			if (cur == prices[i - 1] - 1) {
				last += 1;
			} else {
				last = 1;
			}
			ans += last;
		}
		return ans;
	}

}
