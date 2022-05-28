package 依赖前一个状态.矩阵.路径和路径数;

public class S63不同路径II {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		int[] f = new int[m];

		f[0] = 1;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (obstacleGrid[i][j] != 1 && j > 0 && obstacleGrid[i][j - 1] == 0) {
					f[j] += f[j - 1];
				}
			}
		}
		return f[m - 1];
	}

}
