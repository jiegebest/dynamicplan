package dp.依赖前一个状态.二维矩阵.杨辉三角3;

import java.util.ArrayList;
import java.util.List;

public class S118杨辉三角 {

	public List<List<Integer>> generate(int numRows) {
		int n = numRows;
		int[][] f = new int[n][n];
		for (int i = 0; i < n; ++i) {
			f[i][0] = f[i][i] = 1;
			for (int j = 1; j < i; ++j) {
				f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
			}
		}

		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j <= i; ++j) {
				row.add(f[i][j]);
			}
			res.add(row);
		}
		return res;
	}

}
