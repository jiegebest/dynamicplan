package dp.依赖前一个状态.二维矩阵.最小路径和11;

import java.util.List;

/**
 * n=4
 * 0: 2
 * 1: 3 4
 * 2: 6 5 7
 * 3: 4 1 8 3
 */
public class S120三角形最小路径和 {

	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] f = new int[n][n];
		f[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < n; ++i) {
			List<Integer> row = triangle.get(i);
			f[i][0] = f[i - 1][0] + row.get(0);
			for (int j = 1; j < i; ++j) {
				f[i][j] = row.get(j) + Math.min(f[i - 1][j - 1], f[i - 1][j]);
			}
			f[i][i] = f[i - 1][i - 1] + row.get(i);
		}

		int min = f[n - 1][0];
		for (int j = 1; j < n; ++j) {
			min = Math.min(min, f[n - 1][j]);
		}
		return min;
	}

}
