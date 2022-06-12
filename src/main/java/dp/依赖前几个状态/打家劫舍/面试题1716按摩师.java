package dp.依赖前几个状态.打家劫舍;

public class 面试题1716按摩师 {

	public int massage(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return nums[0];
		}

		int a = nums[0];
		int b = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n; ++i) {
			int temp = Math.max(b, a + nums[i]);
			a = b;
			b = temp;
		}
		return b;
	}

}






