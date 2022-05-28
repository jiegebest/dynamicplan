package 依赖前一个状态.背包._01背包;

public class S剑指OfferII102加减的目标值 {

	public int findTargetSumWays(int[] nums, int target) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		int diff = sum - target;
		if (diff < 0 || (diff & 1) == 1) {
			return 0;
		}

		int n = nums.length, m = diff / 2;
		int[][] f = new int[n + 1][m + 1];
		f[0][0] = 1;
		for (int i = 1; i <= n; ++i) {
			for (int j = 0; j <= m; ++j) {
				f[i][j] = f[i - 1][j] + (nums[i - 1] <= j ? f[i - 1][j - nums[i - 1]] : 0);
			}
		}
		return f[n][m];
	}

}
