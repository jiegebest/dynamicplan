package dp.依赖前一个状态.坐标.二维矩阵.路径.全路径和;

/**
 * 算出所有和，跟 target 比较
 */
public class S1981最小化目标值与所选元素的差 {

	public int minimizeTheDifference(int[][] mat, int target) {
		int max = 70 * 70;
		int m = mat.length;
		int n = mat[0].length;
		boolean[][] f = new boolean[m][max + 1];
		for (int j = 0; j < n; ++j) {
			f[0][mat[0][j]] = true;
		}
		for (int i = 1; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				for (int k = max; k > mat[i][j]; --k) {
					f[i][k] |= f[i - 1][k - mat[i][j]];
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int j = 1; j <= max; ++j) {
			if (f[m - 1][j]) {
				int diff = Math.abs(j - target);
				if (diff < min) {
					min = diff;
				}
			}
		}
		return min;
	}

}
