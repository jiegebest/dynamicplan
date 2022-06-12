package dp.依赖前一个状态.二维矩阵.正方形6.边1矩阵;

public class 面试题1723最大黑方阵 {

	public int[] findSquare(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] f = new int[m][n];
		int[][] g = new int[m][n];

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] == 0) {
					f[i][j] = g[i][j] = 1;
					if (j > 0) {
						f[i][j] += f[i][j - 1];
					}
					if (i > 0) {
						g[i][j] += g[i - 1][j];
					}
				}
			}
		}

		int max = 0, r = 0, c = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (f[i][j] == 0) {
					continue;
				}
				int k = Math.min(f[i][j], g[i][j]);
				if (k <= max) {
					continue;
				}
				while (k > max) {
					int len = k - 1;
					if (g[i][j - len] >= k && f[i - len][j] >= k) {
						max = k;
						r = i - len;
						c = j - len;
						break;
					}
					k--;
				}
			}
		}
		return max == 0 ? new int[0] : new int[]{r, c, max};
	}

}
