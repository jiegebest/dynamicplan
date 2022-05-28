package 依赖前一个状态.矩阵.路径和路径数;

/**
 f[i][j][k]
 第k轮
 f[i][j][k - 1] 往四个方向累加
 */
public class S576出界的路径数 {

	int[] deltaX = {0, 1, 0, -1};
	int[] deltaY = {1, 0, -1, 0};
	static final int MOD = 1000000007;

	public int finfaths(int m, int n, int maxMove, int startRow, int startColumn) {
		int[][][] f = new int[maxMove + 1][m][n];
		f[0][startRow][startColumn] = 1;

		int count = 0;
		for (int r = 1; r <= maxMove; ++r) {
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					for (int k = 0; k < 4; ++k) {
						int x = j + deltaX[k];
						int y = i + deltaY[k];
						if (x < 0 || y < 0 || x >= n || y >= m) {
							count = (count + f[r - 1][i][j]) % MOD;
							continue;
						}
						f[r][y][x] = (f[r][y][x] + f[r - 1][i][j]) % MOD;
					}
				}
			}
		}
		return count;
	}

}
