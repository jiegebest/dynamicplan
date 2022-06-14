package dp.依赖前一个状态.背包._01背包.变形.均分;

public class S416分割等和子集 {

	public boolean canPartition(int[] nums) {
		int m = nums.length;
		if (m == 1) {
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
		int n = sum / 2;
		if (max > n) {
			return false;
		}

		boolean[][] f = new boolean[m][n + 1];
		for (int i = 0; i < m; ++i) {
			f[i][0] = true;
		}
		f[0][nums[0]] = true;

		for (int i = 1; i < m; ++i) {
			for (int j = 1; j <= n; ++j) {
				f[i][j] = f[i - 1][j];
				if (nums[i] <= j) {
					f[i][j] |= f[i - 1][j - nums[i]];
				}
			}
		}
		return f[m - 1][n];
	}

}
