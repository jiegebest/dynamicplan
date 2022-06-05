package dp.依赖前一个状态99.区间13.博弈4;

public class S877石子游戏 {

	public boolean stoneGame(int[] piles) {
		int n = piles.length;
		int[][] f = new int[n][n];
		for (int i = 0; i < n; ++i) {
			f[i][i] = piles[i];
		}

		for (int i = n - 2; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				f[i][j] = Math.max(piles[i] - f[i + 1][j], piles[j] - f[i][j - 1]);
			}
		}
		return f[0][n - 1] > 0;
	}

}
