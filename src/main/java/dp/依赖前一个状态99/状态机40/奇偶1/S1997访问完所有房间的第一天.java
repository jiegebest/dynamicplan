package dp.依赖前一个状态99.状态机40.奇偶1;

/**
 * 绝壁好题
 *
 * 第一次到达位置i，必然回到位置j。注意此时区间[j,i]肯定都是偶数次访问，因为任何一个位置奇数次访问都将导致返回，到不了下一个更大的位置。所以，这就相当于又要重复第一次到达位置j，并最终第一次到达位置i的过程，但实际此时是第二次到达位置i，然后可以继续往前走了。
 *
 * dp[i+1] = (dp[i] + 1) + (dp[i] - dp[nextVisit[i]] + 1)
 * 第一次走到位置i需要dp[i]天；然后返回位置j需要1天；
 * 然后从位置j第一次访问走到位置i需要dp[i]-dp[j]天；
 * 此时位置i是第二次访问，最后需要一天走到位置i+1。
 *
 * 由于有减法运算，取模的时候为避免出现负数，需要加上mod再取模。
 *
 * dp[i] = (2 * dp[i - 1] - dp[nextVisit[i - 1]] + 2 + mod) % mod;
 *
 * f[i] 代表奇数次访问 i 的天数
 * 	 g[i] 代表偶数次访问 i 的天数
 * 	 回跳再回来相当于重来一次，中间的偶数次等于没跳，因为再过来就又成奇数了
 *
 * 	 可能越界，回到负数，再加一个 MOD，保证是正数
 */
public class S1997访问完所有房间的第一天 {

	static final int MOD = 1000000007;

	public int firstDayBeenInAllRooms(int[] nextVisit) {
		int n = nextVisit.length;
		long[] f = new long[n];
		long[] g = new long[n];
		f[0] = 0;
		g[0] = 1;

		for (int i = 1; i < n; ++i) {
			f[i] = (g[i - 1] + 1) % MOD;
			g[i] = (f[i] + 1 + f[i] - f[nextVisit[i]] + MOD) % MOD;
		}

		return (int)f[n - 1];
	}

}
