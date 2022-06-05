package dp.依赖前一个状态99.二维矩阵31.正方形6.边1矩阵;

public class S1139最大的以1为边界的正方形 {

	public int largest1BorderedSquare(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] f = new int[m + 1][n + 1];
		int[][] g = new int[m + 1][n + 1];

		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (grid[i - 1][j - 1] == 1) {
					f[i][j] = f[i][j - 1] + 1;
					g[i][j] = g[i - 1][j] + 1;
				}
			}
		}

		int max = 0;
		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				int k = Math.min(f[i][j], g[i][j]);
				if (k <= max) {
					continue;
				}
				while (k > max) {
					if (g[i][j - (k - 1)] >= k && f[i - (k - 1)][j] >= k) {
						max = k;
						break;
					}
					k--;
				}
			}
		}
		return max * max;
	}

}
