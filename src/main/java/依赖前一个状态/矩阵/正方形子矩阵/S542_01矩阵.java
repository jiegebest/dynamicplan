package 依赖前一个状态.矩阵.正方形子矩阵;

import java.util.Arrays;

/**
 * 取四个方向的值的最小值+1
 */
public class S542_01矩阵 {

	public int[][] updateMatrix(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		int[][] f = new int[n][m];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(f[i], 10000);
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (mat[i][j] == 0) {
					f[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (i > 0) {
					f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
				}
				if (j > 0) {
					f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
				}
			}
		}

		for (int i = 0; i < n; ++i) {
			for (int j = m - 1; j >= 0; j--) {
				if (i > 0) {
					f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
				}
				if (j < m - 1) {
					f[i][j] = Math.min(f[i][j], f[i][j + 1] + 1);
				}
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; ++j) {
				if (i < n - 1) {
					f[i][j] = Math.min(f[i][j], f[i + 1][j] + 1);
				}
				if (j < m - 1) {
					f[i][j] = Math.min(f[i][j], f[i][j + 1] + 1);
				}
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				if (i < n - 1) {
					f[i][j] = Math.min(f[i][j], f[i + 1][j] + 1);
				}
				if (j < m - 1) {
					f[i][j] = Math.min(f[i][j], f[i][j + 1] + 1);
				}
			}
		}

		return f;
	}

}
