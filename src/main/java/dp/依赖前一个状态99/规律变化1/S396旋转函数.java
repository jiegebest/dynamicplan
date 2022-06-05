package dp.依赖前一个状态99.规律变化1;

public class S396旋转函数 {

	public int maxRotateFunction(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		int n = nums.length;
		int[] f = new int[n];
		for (int i = 0; i < n; ++i) {
			f[0] += i * nums[i];
		}

		int max = f[0];
		for (int i = 1; i < n; ++i) {
			f[i] = f[i - 1] + sum - n * nums[n - i];
			max = Math.max(max, f[i]);
		}
		return max;
	}

}
