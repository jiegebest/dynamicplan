package dp.依赖前一个状态.前缀.划分;

import java.util.Arrays;

public class S1959K次调整数组大小浪费的最小总空间 {

	public int minSpaceWastedKResizing(int[] nums, int k) {
		int n = nums.length;
		int[] preSum = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			preSum[i] = preSum[i - 1] + nums[i - 1];
		}

		int[][] max = new int[n][n];
		int[][] waste = new int[n][n];
		for (int i = n - 1; i >= 0; --i) {
			for (int j = i; j < n; ++j) {
				if (i == j) {
					max[i][j] = nums[j];
					waste[i][j] = 0;
				} else {
					max[i][j] = Math.max(max[i][j - 1], nums[j]);
					waste[i][j] = (j - i + 1) * max[i][j] - (preSum[j + 1] - preSum[i]);
				}
			}
		}

		int[][] f = new int[n + 1][k + 1];
		for (int i = 1; i <= n; ++i) {
			Arrays.fill(f[i], Integer.MAX_VALUE);
		}
		for (int i = 1; i <= n; ++i) {
			for (int j = 0; j <= k; ++j) {
				if (j == 0) {
					f[i][0] = waste[0][i - 1];
				} else {
					for (int prev = i - 1; prev >= 0; --prev) {
						f[i][j] = Math.min(f[i][j], f[prev][j - 1] + waste[prev][i - 1]);
					}
				}
			}
		}
		return f[n][k];
	}

}
