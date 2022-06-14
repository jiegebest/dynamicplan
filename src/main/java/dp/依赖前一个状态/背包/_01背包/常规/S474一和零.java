package dp.依赖前一个状态.背包._01背包.常规;

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





