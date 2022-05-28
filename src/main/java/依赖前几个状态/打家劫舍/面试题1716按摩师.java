package 依赖前几个状态.打家劫舍;

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
		int b = nums[1];
		int c = Math.max(nums[0], nums[2]);

		for (int i = 3; i < n; ++i) {
			int temp = nums[i] + Math.max(a, b);
			a = b;
			b = c;
			c = temp;
		}

		return Math.max(b, c);
	}

}






