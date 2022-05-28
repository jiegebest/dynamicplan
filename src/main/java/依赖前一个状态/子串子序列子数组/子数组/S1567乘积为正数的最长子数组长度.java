package 依赖前一个状态.子串子序列子数组.子数组;

public class S1567乘积为正数的最长子数组长度 {

	/**
	 保留最小值和最大值
	 pos[i] 乘积为正数的子数组最长长度
	 neg[i] 乘积为负数的子数组最长长度
	 */
	public int getMaxLen(int[] nums) {
		int n = nums.length;
		int[] pos = new int[n];
		int[] neg = new int[n];
		if (nums[0] > 0) {
			pos[0] = 1;
		} else if (nums[0] < 0) {
			neg[0] = 1;
		}

		int maxLength = pos[0];
		for (int i = 1; i < n; ++i) {
			if (nums[i] == 0) {
				pos[i] = 0;
				neg[i] = 0;
				continue;
			}
			int max = pos[i - 1] + 1;
			int min = neg[i - 1] == 0 ? 0 : neg[i - 1] + 1;
			pos[i] = nums[i] > 0 ? max : min;
			neg[i] = nums[i] > 0 ? min : max;
			maxLength = Math.max(maxLength, pos[i]);
		}
		return maxLength;
	}

}
