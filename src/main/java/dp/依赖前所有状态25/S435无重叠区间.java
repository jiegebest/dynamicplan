package dp.依赖前所有状态25;

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

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (intervals[j][1] <= intervals[i][0]) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
		}

		int max = 0;
		for (int num : f) {
			max = Math.max(max, num);
		}
		return n - max;
	}

	public int eraseOverlapIntervals1(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
		int n = intervals.length, sec = 1, right = intervals[0][1];
		for (int i = 1; i < n; ++i) {
			if (right <= intervals[i][0]) {
				right = intervals[i][1];
				sec++;
			}
		}
		return n - sec;
	}

}
