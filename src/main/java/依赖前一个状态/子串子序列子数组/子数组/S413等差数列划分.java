package 依赖前一个状态.子串子序列子数组.子数组;

public class S413等差数列划分 {

	// 子数组是连续序列 只跟前一个元素的状态有关 fi代表包含i位置的序列个数
	public int numberOfArithmeticSlices(int[] nums) {
		int n = nums.length;
		if (n < 3) {
			return 0;
		}

		int diff = nums[1] - nums[0], count = 0, total = 0;
		for (int i = 2; i < n; ++i) {
			if (nums[i] - nums[i - 1] == diff) {
				count++;
			} else {
				diff = nums[i] - nums[i - 1];
				count = 0;
			}
			total += count;
		}
		return total;
	}

}
