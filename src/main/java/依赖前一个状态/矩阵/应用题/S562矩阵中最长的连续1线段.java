package 依赖前一个状态.矩阵.应用题;

public class S562矩阵中最长的连续1线段 {

	public int longestLine(int[][] mat) {
		int n = mat.length, m = mat[0].length, max = 0;
		// 右 下 右下
		int[][] right = new int[n][m];
		int[][] down = new int[n][m];
		int[][] rightDown = new int[n][m];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (mat[i][j] == 0) {
					continue;
				}
				right[i][j] = down[i][j] = rightDown[i][j] = mat[i][j];
				if (j != 0) {
					right[i][j] += right[i][j - 1];
				}
				if (i != 0) {
					down[i][j] += down[i - 1][j];
				}
				if (i != 0 && j != 0) {
					rightDown[i][j] += rightDown[i - 1][j - 1];
				}
				max = Math.max(max, right[i][j]);
				max = Math.max(max, down[i][j]);
				max = Math.max(max, rightDown[i][j]);
			}
		}

		// 右上
		int[][] rightUp = new int[n][m];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; ++j) {
				if (mat[i][j] == 0) {
					continue;
				}
				rightUp[i][j] = mat[i][j];
				if (i != n - 1 && j != 0) {
					rightUp[i][j] += rightUp[i + 1][j - 1];
				}
				max = Math.max(max, rightUp[i][j]);
			}
		}
		return max;
	}

}
