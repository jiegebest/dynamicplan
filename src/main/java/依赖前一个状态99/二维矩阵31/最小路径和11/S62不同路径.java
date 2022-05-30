package 依赖前一个状态99.二维矩阵31.最小路径和11;

public class S62不同路径 {

	public int uniquePaths(int m, int n) {
		int[][] f = new int[n][m];
		for (int i = 0; i < n; ++i) {
			f[i][0] = 1;
		}
		for (int j = 0; j < m; ++j) {
			f[0][j] = 1;
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 1; j < m; ++j) {
				f[i][j] = f[i][j - 1] + f[i - 1][j];
			}
		}
		return f[n - 1][m - 1];
	}

}
