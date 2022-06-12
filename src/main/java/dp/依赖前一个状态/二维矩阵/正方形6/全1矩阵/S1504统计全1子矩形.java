package dp.依赖前一个状态.二维矩阵.正方形6.全1矩阵;

/**
 * 1 0 1      1 0 1
 * 1 1 0  -> 1 2 0
 * 1 1 0      1 2 0
 */
public class S1504统计全1子矩形 {

	public int numSubmat(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		for (int i = 0; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				if (mat[i][j] == 1) {
					mat[i][j] += mat[i][j - 1];
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				int min = mat[i][j];
				for (int k = i; k >= 0; k--) {
					if (mat[k][j] == 0) {
						break;
					}
					min = Math.min(min, mat[k][j]);
					cnt += min;
				}
			}
		}
		return cnt;
	}

}
