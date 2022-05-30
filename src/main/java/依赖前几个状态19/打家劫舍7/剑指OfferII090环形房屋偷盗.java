package 依赖前几个状态19.打家劫舍7;

public class 剑指OfferII090环形房屋偷盗 {

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}
		if (n == 2) {
			return Math.max(nums[0], nums[1]);
		}
		return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
	}

	public int robRange(int[] nums, int i, int j) {
		int a = nums[i], b = Math.max(nums[i], nums[i + 1]);
		for (int k = i + 2; k <= j; ++k) {
			int temp = Math.max(a + nums[k], b);
			a = b;
			b = temp;
		}
		return b;
	}

}
