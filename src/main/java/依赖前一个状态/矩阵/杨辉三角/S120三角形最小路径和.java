package 依赖前一个状态.矩阵.杨辉三角;

import java.util.List;

public class S120三角形最小路径和 {

	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.isEmpty()) {
			return 0;
		}

		int n = triangle.size();
		int[][] f = new int[2][n];
		f[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < n; ++i) {
			List<Integer> row = triangle.get(i);
			int prev = (i - 1) % 2, curr = i % 2;
			f[curr][0] = f[prev][0] + row.get(0);
			f[curr][i] = f[prev][i - 1] + row.get(i);
			for (int j = 1; j < i; ++j) {
				f[curr][j] = Math.min(f[prev][j - 1], f[prev][j]) + row.get(j);
			}
		}

		int last = (n - 1) % 2, min = f[last][0];
		for (int i = 1; i < n; ++i) {
			min = Math.min(min, f[last][i]);
		}
		return min;
	}

}
