package 未分类41;

import java.util.Arrays;

public class S1477找两个和为目标值且不重叠的子数组 {

	/**
	 滑动双指针+f
	 */
	static final int INF = Integer.MAX_VALUE / 2;

	public int minSumOfLengths(int[] arr, int target) {
		int ans = Integer.MAX_VALUE, n = arr.length;
		int[] f = new int[n];
		Arrays.fill(f, INF);

		for (int i = 0, j = 0, sum = 0; j < n; ++j) {
			sum += arr[j];
			while (i <= j && sum > target) {
				sum -= arr[++i];
			}
			if (sum == target) {
				f[j] = j - i + 1;
				if (i != 0) {
					ans = Math.min(ans, f[i - 1] + f[j]);
				}
			}
			if (j != 0) {
				f[j] = Math.min(f[j], f[j - 1]);
			}
		}
		return ans > n ? -1 : ans;
	}

}
