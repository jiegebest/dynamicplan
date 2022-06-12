package dp.依赖前所有状态.无重复区间;

import java.util.Arrays;

/**
 * 排序左边界，f[i]表示以i结尾的最大区间数，依赖 0 =< j < i
 */
public class S435无重叠区间 {

	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int n = intervals.length;
		int[] f = new int[n];
		Arrays.fill(f, 1);

		int max = 1;
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (intervals[j][1] <= intervals[i][0]) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
			max = Math.max(max, f[i]);
		}
		return n - max;
	}

}
