package dp.依赖前一个状态99.状态机40.不同占位2;

/**
 * 两格都空    1
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
			f[i][0] = f[i - 1][3];
			f[i][1] = (f[i - 1][0] + f[i - 1][2]) % MOD;
			f[i][2] = (f[i - 1][0] + f[i - 1][1]) % MOD;
			f[i][3] = ((f[i - 1][0] + f[i - 1][1]) % MOD + (f[i - 1][2] + f[i - 1][3]) % MOD) % MOD;
		}
		return (int) f[n - 1][3];
	}

}
