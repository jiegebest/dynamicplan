package dp.依赖前一个状态.坐标.二维矩阵.距离;

import java.util.Arrays;

public class S542_01矩阵 {

	public int[][] updateMatrix(int[][] mat) {
		int INF = Integer.MAX_VALUE / 2;
		int m = mat.length, n = mat[0].length;
		int[][] f = new int[m][n];
		for (int i = 0; i < m; ++i) {
			Arrays.fill(f[i], INF);
		}
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (mat[i][j] == 0) {
					f[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (mat[i][j] == 0) {
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

		for (int i = m - 1; i >= 0; --i) {
			for (int j = n - 1; j >= 0; --j) {
				if (mat[i][j] == 0) {
					continue;
				}
				if (i < m - 1) {
					f[i][j] = Math.min(f[i][j], f[i + 1][j] + 1);
				}
				if (j < n - 1) {
					f[i][j] = Math.min(f[i][j], f[i][j + 1] + 1);
				}
			}
		}

		return f;
	}

}
