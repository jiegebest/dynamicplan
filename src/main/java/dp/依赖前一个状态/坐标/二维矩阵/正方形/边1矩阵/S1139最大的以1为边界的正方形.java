package dp.依赖前一个状态.坐标.二维矩阵.正方形.边1矩阵;

public class S1139最大的以1为边界的正方形 {

	public int largest1BorderedSquare(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] right = new int[m + 1][n + 1];
		int[][] down = new int[m + 1][n + 1];

		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (grid[i - 1][j - 1] == 1) {
					right[i][j] = right[i][j - 1] + 1;
					down[i][j] = down[i - 1][j] + 1;
				}
			}
		}

		int max = 0;
		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				int k = Math.min(right[i][j], down[i][j]);
				if (k <= max) {
					continue;
				}
				while (k > max) {
					int d = k - 1;
					if (down[i][j - d] >= k && right[i - d][j] >= k) {
						max = k;
						break;
					}
					--k;
				}
			}
		}
		return max * max;
	}

}
