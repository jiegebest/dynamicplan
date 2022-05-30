package 未分类41;

public class S1594矩阵的最大非负积 {

	public int maxProductPath(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		long[][] maxf = new long[n][m];
		long[][] minf = new long[n][m];
		maxf[0][0] = grid[0][0];
		minf[0][0] = grid[0][0];

		for (int i = 1; i < m; ++i) {
			maxf[0][i] = maxf[0][i - 1] * grid[0][i];
			minf[0][i] = maxf[0][i];
		}
		for (int i = 1; i < n; ++i) {
			maxf[i][0] = maxf[i - 1][0] * grid[i][0];
			minf[i][0] = maxf[i][0];
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 1; j < m; ++j) {
				maxf[i][j] = grid[i][j];
				minf[i][j] = grid[i][j];
				if (grid[i][j] >= 0) {
					maxf[i][j] *= Math.max(maxf[i - 1][j], maxf[i][j - 1]);
					minf[i][j] *= Math.min(minf[i - 1][j], minf[i][j - 1]);
				} else {
					maxf[i][j] *= Math.min(minf[i - 1][j], minf[i][j - 1]);
					minf[i][j] *= Math.max(maxf[i - 1][j], maxf[i][j - 1]);
				}
			}
		}

		if (maxf[n - 1][m - 1] < 0) {
			return -1;
		}
		return (int) (maxf[n - 1][m - 1] % 1000000007);
	}

}
