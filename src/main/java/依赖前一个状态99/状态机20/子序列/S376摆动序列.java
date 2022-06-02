package 依赖前一个状态99.状态机20.子序列;

import java.util.Arrays;

/**
 * up-0
 * down-1
 */
public class S376摆动序列 {

	public int wiggleMaxLength(int[] nums) {
		int n = nums.length;
		int[][] f = new int[n][2];
		Arrays.fill(f[0], 1);
		Arrays.fill(f[1], 1);

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (nums[j] < nums[i]) {
					f[i][0] = Math.max(f[i][0], f[j][1] + 1);
				} else if (nums[j] > nums[i]) {
					f[i][1] = Math.max(f[i][1], f[j][0] + 1);
				}
			}
		}
		return Math.max(f[n - 1][0], f[n - 1][1]);
	}

}
