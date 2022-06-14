package dp.依赖前一个状态.坐标.二维矩阵.路径.最小路径和;

public class S64最小路径和 {

	public int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		for (int j = 1; j < n; ++j) {
			grid[0][j] = grid[0][j - 1] + grid[0][j];
		}
		for (int i = 1; i < m; ++i) {
			grid[i][0] = grid[i - 1][0] + grid[i][0];
		}

		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
			}
		}

		return grid[m - 1][n - 1];
	}

}
