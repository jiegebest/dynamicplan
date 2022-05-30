package 依赖前一个状态99.一维数组6;

public class S413等差数列划分 {

	public int numberOfArithmeticSlices(int[] nums) {
		int n = nums.length;
		if (n < 3) {
			return 0;
		}

		int d = nums[1] - nums[0], cnt = 0, total = 0;
		for (int i = 2; i < n; ++i) {
			if (nums[i] - nums[i - 1] == d) {
				cnt++;
			} else {
				d = nums[i] - nums[i - 1];
				cnt = 0;
			}
			total += cnt;
		}
		return total;
	}

}
