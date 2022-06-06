package dp.依赖前一个状态99.一维数组6.子数组;

public class S53最大子数组和 {

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
