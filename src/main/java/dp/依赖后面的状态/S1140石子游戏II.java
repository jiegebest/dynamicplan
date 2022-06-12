package dp.依赖后面的状态;

public class S1140石子游戏II {

	public int stoneGameII(int[] piles) {
		int n = piles.length, sum = 0;
		int[][] f = new int[n][n + 1];
		for (int i = n - 1; i >= 0; --i) {
			sum += piles[i];
			for (int M = 1; M <= n; M++) {
				if (i + 2 * M >= n) {
					f[i][M] = sum;
				} else {
					for (int X = 1; X <= 2 * M; X++) {
						f[i][M] = Math.max(f[i][M], sum - f[i + X][Math.max(M, X)]);
					}
				}
			}
		}
		return f[0][1];
	}

}
