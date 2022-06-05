package dp.依赖前一个状态99.二维矩阵31.正方形6.全1矩阵;

public class S221最大正方形 {

	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] f = new int[m][n];
		int max = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] == '1') {
					f[i][j] = 1;
					if (i > 0 && j > 0) {
						f[i][j] += Math.min(Math.min(f[i][j - 1], f[i - 1][j]), f[i - 1][j - 1]);
					}
					max = Math.max(max, f[i][j]);
				}
			}
		}
		return max * max;
	}

}
