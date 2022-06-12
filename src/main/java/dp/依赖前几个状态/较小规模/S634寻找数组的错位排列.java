package dp.依赖前几个状态.较小规模;

public class S634寻找数组的错位排列 {

	public int findDerangement(int n) {
		int MOD = 1_000_000_007;
		if (n == 1) {
			return 0;
		}

		long[] f = new long[n + 1];
		f[0] = 1;
		f[1] = 0;
		for (int i = 2; i <= n; ++i) {
			f[i] = ((i - 1) * (f[i - 1] + f[i - 2])) % MOD;
		}
		return (int) f[n];
	}

}
