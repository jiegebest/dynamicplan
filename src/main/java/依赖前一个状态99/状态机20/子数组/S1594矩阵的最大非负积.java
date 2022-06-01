package 依赖前一个状态99.状态机20.子数组;

/**
 * 目的就是为了达到极端，最大值 * 正数，最小值 * 负数
 */
public class S1594矩阵的最大非负积 {

	static final int MOD = 1000000007;

	public int maxProductPath(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		long[][] f = new long[m][n];
		long[][] g = new long[m][n];
		f[0][0] = g[0][0] = grid[0][0];
		for (int i = 1; i < m; ++i) {
			f[i][0] = g[i][0] = grid[i][0] * f[i - 1][0];
		}
		for (int j = 1; j < n; ++j) {
			f[0][j] = g[0][j] = grid[0][j] * f[0][j - 1];
		}

		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				if (grid[i][j] > 0) {
					f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]) * grid[i][j];
					g[i][j] = Math.min(g[i][j - 1], g[i - 1][j]) * grid[i][j];
				} else {
					f[i][j] = Math.min(g[i][j - 1], g[i - 1][j]) * grid[i][j];
					g[i][j] = Math.max(f[i][j - 1], f[i - 1][j]) * grid[i][j];
				}
			}
		}
		return (int) (f[m - 1][n - 1] < 0 ? -1 : f[m - 1][n - 1] % MOD);
	}

}
