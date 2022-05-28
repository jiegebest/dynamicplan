package 依赖前一个状态.矩阵.路径和路径数;

import java.util.Arrays;

public class 剑指OfferII098路径的数目 {

	public int uniquePaths(int m, int n) {
		int[][] f = new int[n][m];
		Arrays.fill(f[0], 1);
		for (int i = 1; i < n; ++i) {
			f[i][0] = 1;
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 1; j < m; ++j) {
				f[i][j] = f[i - 1][j] + f[i][j - 1];
			}
		}
		return f[n - 1][m - 1];
	}

}
