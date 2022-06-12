package dp.依赖前一个状态.一维数组.子数组;

public class 面试题1617连续数列 {

	public int maxSubArray(int[] nums) {
		int n = nums.length;
		int[] f = new int[n];
		f[0] = nums[0];

		int max = nums[0];
		for (int i = 1; i < n; ++i) {
			f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
			max = Math.max(max, f[i]);
		}
		return max;
	}

}
