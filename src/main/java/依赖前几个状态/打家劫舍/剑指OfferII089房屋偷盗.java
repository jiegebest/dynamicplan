package 依赖前几个状态.打家劫舍;

public class 剑指OfferII089房屋偷盗 {

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}

		int a = nums[0], b = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n; ++i) {
			int c = Math.max(a + nums[i], b);
			a = b;
			b = c;
		}
		return b;
	}

}
