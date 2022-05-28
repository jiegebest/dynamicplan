package 依赖前一个状态.矩阵.正方形子矩阵;

/**
 * 向右叠加组成一层的视图，然后从下往上，取较小值作为多层视图
 */
public class S1504统计全1子矩形 {

	public int numSubmat(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		for (int i = 0; i < n; ++i) {
			for (int j = 1; j < m; ++j) {
				if (mat[i][j] == 1) {
					mat[i][j] += mat[i][j - 1];
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
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
