package dp.依赖前一个状态99.状态机40.子数组7;

/**
 * f[i] 当前位+，单独或者累加
 * g[i] 当前位-，累减（不存在单减）
 */
public class S2036最大交替子数组和 {

	public long maximumAlternatingSubarraySum(int[] nums) {
		int n = nums.length;
		long[] f = new long[n];
		long[] g = new long[n];
		f[0] = nums[0];
		long max = nums[0];
		for (int i = 1; i < n; ++i) {
			f[i] = Math.max(g[i - 1], 0) + nums[i];
			g[i] = f[i - 1] - nums[i];
			max = Math.max(max, Math.max(f[i], g[i]));
		}
		return max;
	}

}
