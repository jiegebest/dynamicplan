package 依赖前一个状态.规律变化;

/**
 对规律进行f
 f0 > f1 > f2 > f3
 f0 = xxx
 f1 = f0 + sum - n * nums[n - 1]
 */
public class S396旋转函数 {

	public int maxRotateFunction(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		int f = 0, n = nums.length;
		for (int i = 0; i < n; ++i) {
			f += i * nums[i];
		}

		int max = f;
		for (int i = 1; i < n; ++i) {
			f += sum - n * nums[n - i];
			max = Math.max(max, f);
		}
		return max;
	}

}
