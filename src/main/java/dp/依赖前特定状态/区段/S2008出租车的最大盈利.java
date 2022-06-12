package dp.依赖前特定状态.区段;

import java.util.Arrays;

public class S2008出租车的最大盈利 {

	public long maxTaxiEarnings(int n, int[][] rides) {
		Arrays.sort(rides, (a, b) -> a[1] - b[1]);
		long[] f = new long[n + 1];
		int ride = 0;
		for (int i = 2; i <= n; ++i) {
			f[i] = f[i - 1];
			while (ride < rides.length && rides[ride][1] == i) {
				int start = rides[ride][0];
				int tips = rides[ride][2];
				f[i] = Math.max(f[i], f[start] + i - start + tips);
				++ride;
			}
		}
		return f[n];
	}

}
