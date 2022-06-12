package dp.依赖前一个状态.二维矩阵.最大路径和1;

public class S剑指Offer47礼物的最大价值 {

	public int maxValue(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 1; i < m; ++i) {
			grid[i][0] += grid[i - 1][0];
		}
		for (int j = 1; j < n; ++j) {
			grid[0][j] += grid[0][j - 1];
		}

		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
			}
		}
		return grid[m - 1][n - 1];
	}

}
