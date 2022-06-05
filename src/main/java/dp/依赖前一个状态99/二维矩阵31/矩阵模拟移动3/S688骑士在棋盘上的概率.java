package dp.依赖前一个状态99.二维矩阵31.矩阵模拟移动3;

public class S688骑士在棋盘上的概率 {

	int[] deltaX = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
	int[] deltaY = new int[]{2, 1, -1, -2, -2, -1, 1, 2};

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
				f[r][x][y] += f[r - 1][i][j] / 8;
			}
		}
	}

}
