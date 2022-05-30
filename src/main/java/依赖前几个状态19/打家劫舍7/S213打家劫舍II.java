package 依赖前几个状态19.打家劫舍7;

public class S213打家劫舍II {

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}
		if (n == 2) {
			return Math.max(nums[0], nums[1]);
		}
		return Math.max(robRange(nums, 1, n - 1), robRange(nums, 0, n - 2));
	}

	public int robRange(int[] nums, int i, int j) {
		int a = nums[i], b = Math.max(nums[i], nums[i + 1]);
		for (int k = i + 2; k <= j; ++k) {
			int temp = b;
			b = Math.max(b, a + nums[k]);
			a = temp;
		}
		return Math.max(a, b);
	}

}
