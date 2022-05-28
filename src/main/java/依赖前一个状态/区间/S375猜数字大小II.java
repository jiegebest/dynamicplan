package 依赖前一个状态.区间;

public class S375猜数字大小II {

	/**
	 * 1-n，随机一个位置，剩下位置分两边，取较大值（不管选哪个数字）
	 * 但要控制最小现金数，第一次猜的数字要从1-n里取动态规划的最小值
	 * 区间，由小推大
	 * 简单说，选哪个数字我定，去哪个方向你定
	 */
	public int getMoneyAmount(int n) {
		int[][] f = new int[n + 1][n + 1];
		for (int i = n - 1; i >= 1; i--) {
			for (int j = i + 1; j <= n; ++j) {
				f[i][j] = j + f[i][j - 1];
				for (int k = i; k < j; ++k) {
					int max = k + Math.max(f[i][k - 1], f[k + 1][j]);
					f[i][j] = Math.min(f[i][j], max);
				}
			}
		}
		return f[1][n];
	}

}
