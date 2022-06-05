package dp.依赖前一个状态99.二维矩阵31.最小路径和11;

public class S64最小路径和 {

	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] f = new int[m][n];
		f[0][0] = grid[0][0];
		for (int j = 1; j < n; ++j) {
			f[0][j] = f[0][j - 1] + grid[0][j];
		}

		for (int i = 1; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				f[i][j] = grid[i][j];
				if (j == 0) {
					f[i][j] += f[i - 1][j];
				} else {
					f[i][j] += Math.min(f[i][j - 1], f[i - 1][j]);
				}
			}
		}
		return f[m - 1][n - 1];
	}

}
