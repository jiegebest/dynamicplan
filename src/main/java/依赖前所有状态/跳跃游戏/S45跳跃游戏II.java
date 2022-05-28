package 依赖前所有状态.跳跃游戏;

import java.util.Arrays;

public class S45跳跃游戏II {

	public int jump(int[] nums) {
		int n = nums.length;
		int[] f = new int[n];

		Arrays.fill(f, Integer.MAX_VALUE);
		f[0] = 1;

		for (int i = 0; i < n - 1; ++i) {
			for (int j = 0; j < i; ++j) {
				if (j + nums[j] >= i) {
					f[i] = Math.min(f[i], f[j] + 1);
				}
			}
		}
		return f[n - 1];
	}

	// 贪心解法
	public int jump1(int[] nums) {
		int steps = 0, rightMost = 0, max = 0;
		for (int i = 0; i < nums.length - 1; ++i) {
			// 下一步能到达的最右边界
			max = Math.max(max, i + nums[i]);
			if (i == rightMost) {
				rightMost = max;
				steps++;
			}
		}
		return steps;
	}

}
