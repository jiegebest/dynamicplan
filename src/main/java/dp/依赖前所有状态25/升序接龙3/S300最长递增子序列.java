package dp.依赖前所有状态25.升序接龙3;

import java.util.Arrays;

public class S300最长递增子序列 {

	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] f = new int[n];
		Arrays.fill(f, 1);

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (nums[j] < nums[i]) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n; ++i) {
			max = Math.max(max, f[i]);
		}
		return max;
	}

}
