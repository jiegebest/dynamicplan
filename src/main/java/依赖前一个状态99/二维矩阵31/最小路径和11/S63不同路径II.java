package 依赖前一个状态99.二维矩阵31.最小路径和11;

public class S63不同路径II {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] f = new int[m][n];
		f[0][0] = 1;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (obstacleGrid[i][j] == 1) {
					continue;
				}
				if (i > 0) {
					f[i][j] += f[i - 1][j];
				}
				if (j > 0) {
					f[i][j] += f[i][j - 1];
				}
			}
		}
		return f[m - 1][n - 1];
	}

}
