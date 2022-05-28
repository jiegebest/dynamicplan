package 依赖前一个状态.矩阵.正方形子矩阵;

/**
 * 可以总结出一个模板
 */
public class 面试题1723最大黑方阵 {

	// 四边为0即可，不要求内部为0
	// i,j,k k=0代表横向，k=1代表纵向
	public int[] findSquare(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int[][][] f = new int[n][m][2];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (matrix[i][j] == 0) {
					f[i][j][0] = j == 0 ? 1 : f[i][j - 1][0] + 1;
					f[i][j][1] = i == 0 ? 1 : f[i - 1][j][1] + 1;
				}
			}
		}

		int max = 0, r = 0, c = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (f[i][j][0] == 0) {
					continue;
				}
				int k = Math.min(f[i][j][0], f[i][j][1]);
				if (k <= max) {
					continue;
				}
				while (k > max) {
					int len = k - 1;
					if (f[i][j - len][1] >= k && f[i - len][j][0] >= k) {
						max = k;
						r = i - len;
						c = j - len;
						break;
					}
					k--;
				}
			}
		}
		return max == 0 ? new int[0] : new int[]{r, c, max};
	}

}
