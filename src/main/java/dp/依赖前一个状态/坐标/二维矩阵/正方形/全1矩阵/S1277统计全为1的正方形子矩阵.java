package dp.依赖前一个状态.坐标.二维矩阵.正方形.全1矩阵;

public class S1277统计全为1的正方形子矩阵 {

	public int countSquares(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int cnt = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] == 1) {
					if (i > 0 && j > 0) {
						matrix[i][j] += Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
					}
					cnt += matrix[i][j];
				}
			}
		}
		return cnt;
	}

}
