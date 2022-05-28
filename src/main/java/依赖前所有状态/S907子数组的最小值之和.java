package 依赖前所有状态;

public class S907子数组的最小值之和 {

	// f[i,j]保存区间最小值
	static final int MOD = 1000000007;

	public int sumSubarrayMins(int[] arr) {
		int n = arr.length, sum = 0;
		int[][] f = new int[n][n];

		for (int j = 0; j < n; ++j) {
			for (int i = j; i >= 0; i--) {
				f[i][j] = i == j ? arr[j] : Math.min(f[i][j - 1], arr[j]);
				sum = (sum + f[i][j]) % MOD;
			}
		}

		return sum;
	}

}
