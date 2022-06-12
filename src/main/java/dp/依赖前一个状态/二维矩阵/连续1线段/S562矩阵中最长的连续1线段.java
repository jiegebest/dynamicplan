package dp.依赖前一个状态.二维矩阵.连续1线段;

public class S562矩阵中最长的连续1线段 {

	public int longestLine(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int[][] right = new int[m][n];
		int[][] down = new int[m][n];
		int[][] rightDown = new int[m][n];
		int[][] rightUp = new int[m][n];
		int max = 0;

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (mat[i][j] == 0) {
					continue;
				}
				right[i][j] = down[i][j] = rightDown[i][j] = rightUp[i][j] = mat[i][j];
				if (j > 0) {
					right[i][j] += right[i][j - 1];
				}
				if (i > 0) {
					down[i][j] += down[i - 1][j];
					if (j > 0) {
						rightDown[i][j] += rightDown[i - 1][j - 1];
					}
				}
				max = Math.max(Math.max(max, rightDown[i][j]), Math.max(right[i][j], down[i][j]));
			}
		}

		for (int i = m - 1; i >= 0; --i) {
			for (int j = 0; j < n; ++j) {
				if (mat[i][j] == 1) {
					if (i < n - 1 && j > 0) {
						rightUp[i][j] += rightUp[i + 1][j - 1];
					}
					max = Math.max(max, rightUp[i][j]);
				}
			}
		}
		return max;
	}

}
