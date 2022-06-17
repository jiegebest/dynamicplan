package dp.依赖前一个状态99.背包16._01背包7;

/**
 * 和经典的背包问题只有一种容量不同，这道题有两种容量，即选取的字符串子集中的 0和 1 的数量上限
 * 经典的背包问题可以使用二维动态规划求解，两个维度分别是物品和容量。
 * 这道题有两种容量，因此需要使用三维动态规划求解，三个维度分别是字符串、0 的容量和 1 的容量。
 * f[i][j][k]表示在前 i 个字符串中，使用 j 个 0 和 k 个 1 的情况下最多可以得到的字符串数量
 * f(i, j, k) 前i个字符串组成的最长子集，j为0的个数，k为1的个数
 */
public class S474一和零 {

	public int findMaxForm(String[] strs, int m, int n) {
		int len = strs.length;
		int[][][] f = new int[len + 1][m + 1][n + 1];
		for (int i = 1; i <= len; ++i) {
			int[] zerosOnes = getZerosOnes(strs[i - 1]);
			int zeros = zerosOnes[0], ones = zerosOnes[1];
			for (int j = 0; j <= m; ++j) {
				for (int k = 0; k <= n; ++k) {
					f[i][j][k] = f[i - 1][j][k];
					if (j >= zeros && k >= ones) {
						f[i][j][k] = Math.max(f[i][j][k], f[i - 1][j - zeros][k - ones] + 1);
					}
				}
			}
		}
		return f[len][m][n];
	}

	public int[] getZerosOnes(String str) {
		int[] zerosOnes = new int[2];
		for (int i = 0; i < str.length(); ++i) {
			++zerosOnes[str.charAt(i) - '0'];
		}
		return zerosOnes;
	}

}





