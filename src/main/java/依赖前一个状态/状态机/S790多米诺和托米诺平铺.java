package 依赖前一个状态.状态机;

/**
 * 两格都空   1
 * 占上面一格 2
 * 占下面一格 3
 * 占上下两格 4
 */
public class S790多米诺和托米诺平铺 {

	static final int MOD = 1000000007;

	public int numTilings(int n) {
		long[][] f = new long[n][4];
		f[0][0] = f[0][3] = 1;

		for (int i = 1; i < n; ++i) {
			int prev = i - 1;
			f[i][0] = f[prev][3];
			f[i][1] = (f[prev][0] + f[prev][2]) % MOD;
			f[i][2] = (f[prev][0] + f[prev][1]) % MOD;
			f[i][3] = ((f[prev][0] + f[prev][1]) % MOD + (f[prev][2] + f[prev][3]) % MOD) % MOD;
		}

		return (int) f[n - 1][3];
	}

}
