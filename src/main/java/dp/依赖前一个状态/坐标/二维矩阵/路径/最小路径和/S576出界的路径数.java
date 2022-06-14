package dp.依赖前一个状态.坐标.二维矩阵.路径.最小路径和;

public class S576出界的路径数 {

	public int finfaths(int m, int n, int maxMove, int startRow, int startColumn) {
		int MOD = 1_000_000_007;
		int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int[][][] f = new int[maxMove + 1][m][n];
		f[0][startRow][startColumn] = 1;

		int cnt = 0;
		for (int r = 1; r <= maxMove; ++r) {
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					for (int k = 0; k < 4; ++k) {
						int x = i + dirs[k][0];
						int y = j + dirs[k][1];
						if (x < 0 || y < 0 || x >= m || y >= n) {
							cnt = (cnt + f[r - 1][i][j]) % MOD;
							continue;
						}
						f[r][x][y] = (f[r][x][y] + f[r - 1][i][j]) % MOD;
					}
				}
			}
		}
		return cnt;
	}

}
