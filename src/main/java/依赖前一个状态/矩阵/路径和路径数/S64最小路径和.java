package 依赖前一个状态.矩阵.路径和路径数;

public class S64最小路径和 {

	public int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[] f = new int[m];
		f[0] = grid[0][0];
		for (int j = 1; j < m; ++j) {
			f[j] = f[j - 1] + grid[0][j];
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				f[j] += grid[i][j];
				if (j != 0) {
					f[j] += Math.min(f[j], f[j - 1]);
				}
			}
		}
		return f[m - 1];
	}

}
