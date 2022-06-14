package dp.依赖前一个状态.坐标.二维矩阵.距离;

/**
 * 0-水平，1-垂直，2-右下，3-右上
 */
public class S562矩阵中最长的连续1线段 {

	public int longestLine(int[][] mat) {
		int m = mat.length, n = mat[0].length;
		int[][][] f = new int[m][n][4];
		int max = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (mat[i][j] == 1) {
					f[i][j][0] = f[i][j][1] = f[i][j][2] = f[i][j][3] = 1;
					if (j > 0) {
						f[i][j][0] += f[i][j - 1][0];
					}
					if (i > 0) {
						f[i][j][1] += f[i - 1][j][1];
						if (j > 0) {
							f[i][j][2] += f[i - 1][j - 1][2];
						}
					}
					max = Math.max(Math.max(max, f[i][j][0]), Math.max(f[i][j][1], f[i][j][2]));
				}
			}
		}

		for (int i = m - 1; i >= 0; --i) {
			for (int j = 0; j < n; ++j) {
				if (mat[i][j] == 1) {
					if (i < m - 1 && j > 0) {
						f[i][j][3] += f[i + 1][j - 1][3];
					}
					max = Math.max(max, f[i][j][3]);
				}
			}
		}
		return max;
	}

}
