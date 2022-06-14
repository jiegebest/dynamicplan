package dp.依赖前一个状态.背包.多重背包;

public class S1155掷骰子的N种方法 {
	
	public int numRollsToTarget(int n, int k, int target) {
		int m = target;
		int[][] f = new int[n + 1][m + 1];
		int limit = Math.min(k, m);
		for (int i = 1; i <= limit; ++i) {
			f[1][i] = 1;
		}

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				for (int v = 1; v <= limit && v < j; ++v) {
					f[i][j] = (f[i][j] + f[i - 1][j - v]) % 1_000_000_007;
				}
			}
		}
		return f[n][m];
	}

}
