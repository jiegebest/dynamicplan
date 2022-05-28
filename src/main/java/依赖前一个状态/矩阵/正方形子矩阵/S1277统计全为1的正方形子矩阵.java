package 依赖前一个状态.矩阵.正方形子矩阵;

/**
 * i,j = min{(i,j-1), (i-1,j), (i-1,j-1)} + 1
 */
public class S1277统计全为1的正方形子矩阵 {

	public int countSquares(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		for (int i = 1; i < n; ++i) {
			for (int j = 1; j < m; ++j) {
				if (matrix[i][j] == 1) {
					matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				cnt += matrix[i][j];
			}
		}
		return cnt;
	}

}
