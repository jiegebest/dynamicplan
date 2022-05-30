package 依赖前一个状态99.状态机18.子数组;

/**
 * 保留最小值和最大值
 * pos[i] 乘积为正数的子数组最长长度
 * neg[i] 乘积为负数的子数组最长长度
 */
public class S1567乘积为正数的最长子数组长度 {

	public int getMaxLen(int[] nums) {
		int n = nums.length;
		int[] pos = new int[n];
		int[] neg = new int[n];
		if (nums[0] > 0) {
			pos[0] = 1;
		} else if (nums[0] < 0) {
			neg[0] = 1;
		}

		int ans = 0;
		for (int i = 1; i < n; ++i) {
			if (nums[i] == 0) {
				pos[i] = 0;
				neg[i] = 0;
			} else if (nums[i] > 0) {
				pos[i] = pos[i - 1] + 1;
				neg[i] = neg[i - 1] > 0 ? neg[i - 1] + 1 : 0;
			} else {
				pos[i] = neg[i - 1] > 0 ? neg[i - 1] + 1 : 0;
				neg[i] = pos[i - 1] + 1;
			}
			ans = Math.max(ans, pos[i]);
		}
		return ans;
	}

}
