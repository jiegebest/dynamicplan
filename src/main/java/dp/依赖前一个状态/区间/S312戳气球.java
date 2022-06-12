package dp.依赖前一个状态.区间;

public class S312戳气球 {

	public int maxCoins(int[] nums) {
		int n = nums.length;
		int[] arr = new int[n + 2];
		arr[0] = arr[n + 1] = 1;
		for (int i = 1; i <= n; ++i) {
			arr[i] = nums[i - 1];
		}

		int[][] f = new int[n + 2][n + 2];
		for (int i = n - 1; i >= 0; --i) {
			for (int j = i + 2; j <= n + 1; ++j) {
				for (int k = i + 1; k <= j - 1; ++k) {
					f[i][j] = Math.max(f[i][j], arr[i] * arr[k] * arr[j] + f[i][k] + f[k][j]);
				}
			}
		}
		return f[0][n + 1];
	}

}
