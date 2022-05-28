package 依赖前一个状态.矩阵.杨辉三角;

import java.util.List;

public class 剑指OfferII100三角形中最小路径之和 {

	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.isEmpty()) {
			return 0;
		}

		int n = triangle.size();
		int[][] f = new int[n][n];
		for (int i = 0; i < n; ++i) {
			List<Integer> row = triangle.get(i);
			for (int j = 0; j < row.size(); ++j) {
				f[i][j] = row.get(j);
			}
		}

		for (int i = 1; i < n; ++i) {
			f[i][0] += f[i - 1][0];
			f[i][i] += f[i - 1][i - 1];
			for (int j = 1; j < i; ++j) {
				f[i][j] += Math.min(f[i - 1][j - 1], f[i - 1][j]);
			}
		}

		int min = f[n - 1][0];
		for (int i = 1; i < n; ++i) {
			min = Math.min(min, f[n - 1][i]);
		}
		return min;
	}

}
