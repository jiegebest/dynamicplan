package dp.依赖前一个状态.前缀.划分;

/**
 * f[i][j][0] 不连i 组成 j 段
 * = f[i - 1][j][0] + f[i - 1][j][1]
 * f[i][j][1]   连i 组成 j 段：连i的长度=1，连i的长度>1
 * = 长度=1 单开 f[i - 1][j - 1][0] + f[i - 1][j - 1][1]
 * = 长度>1 延长 f[i - 1][j][1]
 */
public class S1621大小为K的不重叠线段的数目 {

	static final int MOD = 1000000007;

	public int numberOfSets(int n, int k) {
		int[][][] f = new int[n][k + 1][2];
		f[0][0][0] = 1;

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j <= k; ++j) {
				f[i][j][0] = (f[i - 1][j][0] + f[i - 1][j][1]) % MOD;
				f[i][j][1] = f[i - 1][j][1];
				if (j > 0) {
					f[i][j][1] = (f[i][j][1] + f[i - 1][j - 1][0]) % MOD;
					f[i][j][1] = (f[i][j][1] + f[i - 1][j - 1][1]) % MOD;
				}
			}
		}

		return (f[n - 1][k][0] + f[n - 1][k][1]) % MOD;
	}

}
