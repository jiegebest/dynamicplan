package 依赖前所有状态25;

public class S907子数组的最小值之和 {

	static final int MOD = 1000000007;

	public int sumSubarrayMins(int[] arr) {
		int n = arr.length, sum = 0;
		int[][] f = new int[n][n];
		for (int j = 0; j < n; ++j) {
			for (int i = j; i >= 0; --i) {
				if (i == j) {
					f[i][j] = arr[j];
				} else {
					f[i][j] = Math.min(f[i][j - 1], arr[j]);
				}
				sum = (sum + f[i][j]) % MOD;
			}
		}
		return sum;
	}

}
