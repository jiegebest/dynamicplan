package dp.依赖前一个状态.二维矩阵.杨辉三角3;

import java.util.ArrayList;
import java.util.List;

public class S119杨辉三角II {

	public List<Integer> getRow(int rowIndex) {
		int n = rowIndex + 1;
		int[][] f = new int[n][n];
		for (int i = 0; i < n; ++i) {
			f[i][0] = f[i][i] = 1;
			for (int j = 1; j < i; ++j) {
				f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
			}
		}

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			res.add(f[n - 1][i]);
		}
		return res;
	}

}
