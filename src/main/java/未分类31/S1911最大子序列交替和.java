package 未分类31;

public class S1911最大子序列交替和 {

	public long maxAlternatingSum(int[] nums) {
		int len = nums.length;
		// i作为奇数位置结尾最大
		long[] o = new long[len];
		// i作为偶数位置结尾最大
		long[] e = new long[len];
		e[0] = nums[0];
		for (int i = 1; i < e.length; ++i) {
			// i作为偶数结尾 == Max(i位置 + i-1奇数结尾最大, i - 1位置偶数结尾最大值)
			e[i] = Math.max(nums[i] + o[i - 1], e[i - 1]);
			// i作为奇数结尾最大值 == Max(i-1偶数结尾最大 - i位置, i - 1位置奇数数结尾最大值)
			o[i] = Math.max(e[i - 1] - nums[i], o[i - 1]);
		}
		// len - 1 偶数结尾中产生结果，奇数会被减掉比偶数小
		return e[len - 1];
	}

}
