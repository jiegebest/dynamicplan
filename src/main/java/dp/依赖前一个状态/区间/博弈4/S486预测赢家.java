package dp.依赖前一个状态.区间.博弈4;

public class S486预测赢家 {

	public boolean PredictTheWinner(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return true;
		}
		int[][] f = new int[n][n];
		for (int i = 0; i < n; ++i) {
			f[i][i] = nums[i];
		}

		for (int i = n - 2; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				f[i][j] = Math.max(nums[i] - f[i + 1][j], nums[j] - f[i][j - 1]);
			}
		}
		return f[0][n - 1] >= 0;
	}

}
