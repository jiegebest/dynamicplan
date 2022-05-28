package 依赖前一个状态.矩阵.杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class S119杨辉三角II {

	public List<Integer> getRow(int rowIndex) {
		int n = rowIndex;
		int[][] f = new int[2][n + 1];
		f[0][0] = 1;

		for (int i = 1; i <= n; ++i) {
			f[i % 2][0] = 1;
			for (int j = 1; j < i; ++j) {
				f[i % 2][j] = f[(i - 1) % 2][j - 1] + f[(i - 1) % 2][j];
			}
			f[i % 2][i] = 1;
		}

		List<Integer> row = new ArrayList<>(n + 1);
		for (int i = 0; i <= n; ++i) {
			row.add(f[n % 2][i]);
		}
		return row;
	}

}
