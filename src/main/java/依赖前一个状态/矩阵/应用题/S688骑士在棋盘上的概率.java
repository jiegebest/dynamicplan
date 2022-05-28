package 依赖前一个状态.矩阵.应用题;

public class S688骑士在棋盘上的概率 {

	int[] deltaX = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
	int[] deltaY = new int[]{2, 1, -1, -2, -2, -1, 1, 2};

	// 每一步的状态只有i,j不够，有可能多个不同的来源到达同一个坐标。需要增加一个维度，轮次
	public double knightProbability(int n, int k, int row, int column) {
		double[][][] f = new double[k + 1][n][n];
		f[0][row][column] = 1;

		for (int r = 1; r <= k; ++r) {
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (f[r - 1][i][j] != 0) {
						moveNext(f, r, i, j, n);
					}
				}
			}
		}

		double total = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				total += f[k][i][j];
			}
		}
		return total;
	}

	public void moveNext(double[][][] f, int r, int i, int j, int n) {
		for (int k = 0; k < 8; ++k) {
			int x = i + deltaX[k];
			int y = j + deltaY[k];
			if (x >= 0 && y >= 0 && x < n && y < n) {
				// 有1/8的概率移往每个方向
				f[r][x][y] += f[r - 1][i][j] / 8;
			}
		}
	}

}
