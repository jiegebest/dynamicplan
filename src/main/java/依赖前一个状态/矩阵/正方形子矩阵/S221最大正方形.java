package 依赖前一个状态.矩阵.正方形子矩阵;

public class S221最大正方形 {

	public int maximalSquare(char[][] matrix) {
		int n = matrix.length, m = matrix[0].length;
		int[][] f = new int[n][m];
		int max = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (matrix[i][j] == '0') {
					continue;
				}
				f[i][j] = 1;
				if (i != 0 && j != 0) {
					f[i][j] += Math.min(Math.min(f[i][j - 1], f[i - 1][j]), f[i - 1][j - 1]);
				}
				max = Math.max(max, f[i][j]);
			}
		}
		return max * max;
	}

}
