package dp.依赖前一个状态.状态机.子数组;

/**
 * f[i] 当前位+，单独或者累加
 * g[i] 当前位-，累减（不存在单减）
 */
public class S2036最大交替子数组和 {

	public long maximumAlternatingSubarraySum(int[] nums) {
		int n = nums.length;
		long[] add = new long[n];
		long[] sub = new long[n];
		add[0] = nums[0];

		long max = nums[0];
		for (int i = 1; i < n; ++i) {
			add[i] = Math.max(sub[i - 1], 0) + nums[i];
			sub[i] = add[i - 1] - nums[i];
			max = Math.max(max, Math.max(add[i], sub[i]));
		}
		return max;
	}

}
