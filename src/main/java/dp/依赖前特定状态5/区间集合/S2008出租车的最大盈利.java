package dp.依赖前特定状态5.区间集合;

import java.util.Arrays;

/**
 * 这个不需要覆盖整条路径
 * f[i] max
 * 不接终点为 i 的乘客，f[i] = f[i - 1]
 *     接终点为 i 的乘客，f[i] = f[ride[0]] + ride[1] - ride[0] + ride[2]
 */
public class S2008出租车的最大盈利 {

	public long maxTaxiEarnings(int n, int[][] rides) {
		Arrays.sort(rides, (a, b) -> a[1] - b[1]);

		long[] f = new long[n + 1];
		int j = 0;
		for (int i = 2; i <= n; ++i) {
			f[i] = f[i - 1];
			while (j < rides.length && rides[j][1] == i) {
				f[i] = Math.max(f[i], f[rides[j][0]] + rides[j][1] - rides[j][0] + rides[j][2]);
				++j;
			}
		}
		return f[n];
	}

}
