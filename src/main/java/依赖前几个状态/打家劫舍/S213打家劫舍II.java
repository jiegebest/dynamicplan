package 依赖前几个状态.打家劫舍;

public class S213打家劫舍II {

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}
		if (n == 2) {
			return Math.max(nums[0], nums[1]);
		}

		// 第一个不选的情况 或 第一个选的情况，最后一个不可选
		return Math.max(robRange(nums, 1, n - 1), robRange(nums, 0, n - 2));
	}

	public int robRange(int[] nums, int start, int end) {
		int a = nums[start], b = Math.max(nums[start], nums[start + 1]);
		for (int i = start + 2; i <= end; ++i) {
			int temp = b;
			b = Math.max(b, a + nums[i]);
			a = temp;
		}
		return Math.max(a, b);
	}

}
