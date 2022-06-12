package dp.依赖前一个状态.背包._01背包7;

public class S1155掷骰子的N种方法 {
	
	static final int MOD = 1000000007;

	public int numRollsToTarget(int n, int k, int target) {
		int m = target;
		int[][] f = new int[n + 1][m + 1];
		int min = Math.min(k, m);
		for (int i = 1; i <= min; ++i) {
			f[1][i] = 1;
		}

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				for (int v = 1; v <= min && v < j; ++v) {
					f[i][j] = (f[i][j] + f[i - 1][j - v]) % MOD;
				}
			}
		}
		return f[n][m];
	}

}
