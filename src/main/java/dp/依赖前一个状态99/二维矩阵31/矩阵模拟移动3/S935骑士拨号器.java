package dp.依赖前一个状态99.二维矩阵31.矩阵模拟移动3;

/**
 * n 步的不同排列
 */
public class S935骑士拨号器 {

	public int knightDialer(int n) {
		int[][] dirs = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
		int MOD = 1_000_000_007;

		int[][][] f = new int[n][4][3];
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				f[0][i][j] = 1;
			}
		}
		f[0][3][1] = 1;

		for (int k = 1; k < n; ++k) {
			for (int i = 0; i < 4; ++i) {
				for (int j = 0; j < 3; ++j) {
					if (i == 3 && (j == 0 || j == 2)) {
						continue;
					}
					for (int t = 0; t < 8; ++t) {
						int x = i + dirs[t][0];
						int y = j + dirs[t][1];
						if (x >= 0 && x < 3 && y >= 0 && y < 3 || x == 3 && y == 1) {
							f[k][x][y] = (f[k][x][y] + f[k - 1][i][j]) % MOD;
						}
					}
				}
			}
		}

		int total = 0;
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 3; ++j) {
				total = (total + f[n - 1][i][j]) % MOD;
			}
		}
		return total;
	}

}
