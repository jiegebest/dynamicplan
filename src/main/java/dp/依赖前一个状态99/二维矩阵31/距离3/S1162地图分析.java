package dp.依赖前一个状态99.二维矩阵31.距离3;

public class S1162地图分析 {

	static final int INF = Integer.MAX_VALUE / 2;

	public int maxDistance(int[][] grid) {
		int n = grid.length;
		int[][] f = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 0) {
					f[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 0) {
					if (i > 0) {
						f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
					}
					if (j > 0) {
						f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
					}
				}
			}
		}

		int max = -1;
		for (int i = n - 1; i >= 0; --i) {
			for (int j = n - 1; j >= 0; j--) {
				if (grid[i][j] == 0) {
					if (i < n - 1) {
						f[i][j] = Math.min(f[i][j], f[i + 1][j] + 1);
					}
					if (j < n - 1) {
						f[i][j] = Math.min(f[i][j], f[i][j + 1] + 1);
					}
					max = Math.max(max, f[i][j]);
				}
			}
		}
		return max >= INF ? -1 : max;
	}

}
