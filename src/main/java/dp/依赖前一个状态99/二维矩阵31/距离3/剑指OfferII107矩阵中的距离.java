package dp.依赖前一个状态99.二维矩阵31.距离3;

import java.util.Arrays;

public class 剑指OfferII107矩阵中的距离 {

	static final int INF = Integer.MAX_VALUE / 2;

	public int[][] updateMatrix(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
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
				if (i > 0) {
					f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
				}
				if (j > 0) {
					f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
				}
			}
		}

		for (int i = m - 1; i >= 0; --i) {
			for (int j = n - 1; j >= 0; j--) {
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
