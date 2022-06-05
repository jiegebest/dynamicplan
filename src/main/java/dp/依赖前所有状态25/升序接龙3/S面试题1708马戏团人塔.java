package dp.依赖前所有状态25.升序接龙3;

import java.util.Arrays;

/**
 * 题目要求是“矮一点 且 轻一点”，是严格要求<而不是<=
 * 先根据身高 升序排序，若身高一样则根据体重 降序排序。
 * 这样就保证了身高一致，体重只取一次
 *
 * TLE 没办法
 * 问题转化成了最长上升子序列
 */
public class S面试题1708马戏团人塔 {

	public int bestSeqAtIndex(int[] height, int[] weight) {
		int n = height.length;
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; ++i) {
			arr[i][0] = height[i];
			arr[i][1] = weight[i];
		}
		Arrays.sort(arr, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

		int max = 0;
		int[] f = new int[n];
		Arrays.fill(f, 1);
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (arr[j][1] < arr[i][1]) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
			max = Math.max(max, f[i]);
		}
		return max;
	}

}
