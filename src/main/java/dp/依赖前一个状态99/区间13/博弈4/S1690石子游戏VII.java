package dp.依赖前一个状态99.区间13.博弈4;

public class S1690石子游戏VII {

	public int stoneGameVII(int[] stones) {
		int n = stones.length;
		int[][] f = new int[n][n];
		for (int i = n - 2; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				if (i + 1 == j) {
					f[i][j] = Math.max(stones[i], stones[j]);
				} else {
					int left = Math.min(stones[i + 1] + f[i + 2][j], f[i + 1][j - 1] + stones[j]);
					int right = Math.min(stones[i] + f[i + 1][j - 1], f[i][j - 2] + stones[j - 1]);
					f[i][j] = Math.max(left, right);
				}
			}
		}
		return f[0][n - 1];
	}

}
