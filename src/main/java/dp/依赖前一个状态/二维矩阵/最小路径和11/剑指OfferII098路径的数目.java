package dp.依赖前一个状态.二维矩阵.最小路径和11;

import java.util.Arrays;

public class 剑指OfferII098路径的数目 {

	public int uniquePaths(int m, int n) {
		int[][] f = new int[m][n];
		Arrays.fill(f[0], 1);
		for (int i = 1; i < m; ++i) {
			f[i][0] = 1;
		}

		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				f[i][j] = f[i][j - 1] + f[i - 1][j];
			}
		}
		return f[m - 1][n - 1];
	}

}
