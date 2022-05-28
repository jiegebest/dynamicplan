package 依赖前一个状态.矩阵.应用题;

public class S剑指Offer47礼物的最大价值 {

	public int maxValue(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[] f = new int[m];
		f[0] = grid[0][0];
		for (int j = 1; j < m; ++j) {
			f[j] = f[j - 1] + grid[0][j];
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				f[j] = grid[i][j] + (j == 0 ? f[j] : Math.max(f[j], f[j - 1]));
			}
		}
		return f[m - 1];
	}

}
