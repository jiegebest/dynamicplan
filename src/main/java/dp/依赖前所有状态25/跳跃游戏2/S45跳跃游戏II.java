package dp.依赖前所有状态25.跳跃游戏2;

import java.util.Arrays;

public class S45跳跃游戏II {

	static final int MOD = Integer.MAX_VALUE / 2;

	public int jump(int[] nums) {
		int n = nums.length;
		int[] f = new int[n];
		Arrays.fill(f, MOD);
		f[0] = 0;

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (j + nums[j] >= i) {
					f[i] = Math.min(f[i], f[j] + 1);
				}
			}
		}
		return f[n - 1];
	}

}
