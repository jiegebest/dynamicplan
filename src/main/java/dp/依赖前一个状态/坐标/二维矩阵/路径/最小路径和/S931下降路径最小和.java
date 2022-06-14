package dp.依赖前一个状态.坐标.二维矩阵.路径.最小路径和;

public class S931下降路径最小和 {

	public int minFallingPathSum(int[][] A) {
		int m = A.length, n = A[0].length;
		for (int i = 1; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (j == 0) {
					A[i][j] += Math.min(A[i - 1][j], A[i - 1][j + 1]);
				} else if (j == n - 1) {
					A[i][j] += Math.min(A[i - 1][j], A[i - 1][j - 1]);
				} else {
					A[i][j] += Math.min(A[i - 1][j], Math.min(A[i - 1][j - 1], A[i - 1][j + 1]));
				}
			}
		}

		int min = A[m - 1][0];
		for (int j = 1; j < n; ++j) {
			min = Math.min(min, A[m - 1][j]);
		}
		return min;
	}

}
