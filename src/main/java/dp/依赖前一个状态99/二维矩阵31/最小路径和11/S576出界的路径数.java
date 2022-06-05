package dp.依赖前一个状态99.二维矩阵31.最小路径和11;

public class S576出界的路径数 {

	int[] deltaX = {0, 1, 0, -1};
	int[] deltaY = {1, 0, -1, 0};
	static final int MOD = 1000000007;

	public int finfaths(int m, int n, int maxMove, int startRow, int startColumn) {
		int[][][] f = new int[maxMove + 1][m][n];
		f[0][startRow][startColumn] = 1;
		int cnt = 0;
		for (int r = 1; r <= maxMove; ++r) {
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					for (int k = 0; k < 4; ++k) {
						int x = i + deltaX[k];
						int y = j + deltaY[k];
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
