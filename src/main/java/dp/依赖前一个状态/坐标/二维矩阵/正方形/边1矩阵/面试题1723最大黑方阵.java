package dp.依赖前一个状态.坐标.二维矩阵.正方形.边1矩阵;

public class 面试题1723最大黑方阵 {

	public int[] findSquare(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int[][] right = new int[m][n];
		int[][] down = new int[m][n];

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] == 0) {
					right[i][j] = down[i][j] = 1;
					if (j > 0) {
						right[i][j] += right[i][j - 1];
					}
					if (i > 0) {
						down[i][j] += down[i - 1][j];
					}
				}
			}
		}

		int max = 0, r = 0, c = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (right[i][j] == 0) {
					continue;
				}
				int k = Math.min(right[i][j], down[i][j]);
				if (k <= max) {
					continue;
				}
				while (k > max) {
					int d = k - 1;
					if (down[i][j - d] >= k && right[i - d][j] >= k) {
						max = k;
						r = i - d;
						c = j - d;
						break;
					}
					k--;
				}
			}
		}
		return max == 0 ? new int[0] : new int[]{r, c, max};
	}

}
