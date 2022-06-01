package 未分类31;

import java.util.Arrays;

public class S2008出租车的最大盈利 {

	public long maxTaxiEarnings(int n, int[][] rides) {
		long[] f = new long[n + 1];
		//按终点由小到大排序
		Arrays.sort(rides, (a, b) -> a[1] - b[1]);
		int index = 0;
		for (int i = 1; i <= n; ++i) {
			//出租车从i-1位置走到i位置,不载人时他的最大收益等于f[i-1]
			f[i] = f[i - 1];
			while (index < rides.length && rides[index][1] <= i) {
				//更新以i为终点载人情况的最大盈利
				f[i] = Math.max(f[i], f[rides[index][0]] + rides[index][1] - rides[index][0] + rides[index][2]);
				index++;
			}
		}
		return f[n];
	}

}
