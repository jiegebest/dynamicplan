package 依赖前一个状态.矩阵.杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class S118杨辉三角 {

	public List<List<Integer>> generate(int numRows) {
		int n = numRows;
		if (n <= 0) {
			return new ArrayList<>();
		}

		List<List<Integer>> rows = new ArrayList<>(n);
		int[][] f = new int[n][n];
		for (int i = 0; i < n; ++i) {
			f[i][0] = 1;
			f[i][i] = 1;
			for (int j = 1; j < i; ++j) {
				f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
			}
		}

		for (int i = 0; i < n; ++i) {
			List<Integer> row = new ArrayList<>(i + 1);
			for (int j = 0; j <= i; ++j) {
				row.add(f[i][j]);
			}
			rows.add(row);
		}
		return rows;
	}

}
