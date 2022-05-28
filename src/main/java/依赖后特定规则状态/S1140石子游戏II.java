package 依赖后特定规则状态;

public class S1140石子游戏II {

	// 依赖后面2M个状态 特定规则 fi,j 代表剩余第i开始的石子，M=j 先取最大值
	// 对于博弈型，依赖未来值，所以依赖是从后往前。依赖未知而不是已知。
	public int stoneGameII(int[] piles) {
		int n = piles.length, sum = 0;
		int[][] f = new int[n][n + 1];

		for (int i = n - 1; i >= 0; i--) {
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
