package 依赖前所有状态25.子序列3;

import java.util.Arrays;

public class S1218最长定差子序列 {

	public int longestSubsequence(int[] arr, int difference) {
		int n = arr.length, max = 1;
		int[] f = new int[n];
		Arrays.fill(f, 1);

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (arr[i] - arr[j] == difference) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
			max = Math.max(max, f[i]);
		}
		return max;
	}

}
