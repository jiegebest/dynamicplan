package dp.依赖前一个状态.坐标.二维矩阵.模拟;

public class S688骑士在棋盘上的概率 {

	public double knightProbability(int n, int k, int row, int column) {
		int[][] dirs = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
		double[][][] f = new double[k + 1][n][n];
		f[0][row][column] = 1;

		for (int r = 1; r <= k; ++r) {
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (f[r - 1][i][j] == 0) {
						continue;
					}
					for (int t = 0; t < 8; ++t) {
						int x = i + dirs[t][0];
						int y = j + dirs[t][1];
						if (x >= 0 && y >= 0 && x < n && y < n) {
							f[r][x][y] += f[r - 1][i][j] / 8;
						}
					}
				}
			}
		}

		double prob = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				prob += f[k][i][j];
			}
		}
		return prob;
	}

}
