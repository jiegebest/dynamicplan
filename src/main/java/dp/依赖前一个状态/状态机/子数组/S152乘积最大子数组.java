package dp.依赖前一个状态.状态机.子数组;

public class S152乘积最大子数组 {

	public int maxFProduct(int[] nums) {
		int n = nums.length;
		int[] maxF = new int[n];
		int[] minF = new int[n];
		maxF[0] = minF[0] = nums[0];

		int ans = maxF[0];
		for (int i = 1; i < n; ++i) {
			if (nums[i] >= 0) {
				maxF[i] = Math.max(nums[i], nums[i] * maxF[i - 1]);
				minF[i] = Math.min(nums[i], nums[i] * minF[i - 1]);
			} else {
				maxF[i] = Math.max(nums[i], nums[i] * minF[i - 1]);
				minF[i] = Math.min(nums[i], nums[i] * maxF[i - 1]);
			}
			ans = Math.max(ans, maxF[i]);
		}
		return ans;
	}

}
