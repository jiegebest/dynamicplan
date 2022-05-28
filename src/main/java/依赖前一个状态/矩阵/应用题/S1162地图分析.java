package 依赖前一个状态.矩阵.应用题;

public class S1162地图分析 {

	public int maxDistance(int[][] grid) {
		int n = grid.length, DEF = 1000;
		int[][] f = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 0) {
					f[i][j] = DEF;
				}
			}
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 1) {
					continue;
				}
				if (i > 0) {
					f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
				}
				if (j > 0) {
					f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
				}
			}
		}

		int max = -1;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (grid[i][j] == 1) {
					continue;
				}
				if (i < n - 1) {
					f[i][j] = Math.min(f[i][j], f[i + 1][j] + 1);
				}
				if (j < n - 1) {
					f[i][j] = Math.min(f[i][j], f[i][j + 1] + 1);
				}
				max = Math.max(max, f[i][j]);
			}
		}
		return max >= DEF ? -1 : max;
	}

}
