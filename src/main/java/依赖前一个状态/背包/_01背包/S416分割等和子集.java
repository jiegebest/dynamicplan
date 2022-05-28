package 依赖前一个状态.背包._01背包;

public class S416分割等和子集 {

	public boolean canPartition(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return false;
		}

		int sum = 0, max = 0;
		for (int num : nums) {
			sum += num;
			max = Math.max(max, num);
		}
		if ((sum & 1) == 1) {
			return false;
		}
		int target = sum / 2;
		if (max > target) {
			return false;
		}

		boolean[][] f = new boolean[n][target + 1];
		for (int i = 0; i < n; ++i) {
			f[i][0] = true;
		}
		f[0][nums[0]] = true;

		for (int i = 1; i < n; ++i) {
			for (int j = 1; j <= target; ++j) {
				if (nums[i] > j) {
					f[i][j] = f[i - 1][j];
				} else {
					f[i][j] = f[i - 1][j] || f[i - 1][j - nums[i]];
				}
			}
		}
		return f[n - 1][target];
	}

}
