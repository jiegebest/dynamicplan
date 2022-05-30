package 依赖前一个状态99.状态机18.子数组;

/**
 * f 奇数前缀和
 * g 偶数前缀和
 */
public class S1524和为奇数的子数组数目 {

	static final int MOD = 1000000007;

	public int numOfSubarrays(int[] arr) {
		int n = arr.length;
		int[] prefixSum = new int[n + 1];
		int[] f = new int[n + 1];
		int[] g = new int[n + 1];
		f[0] = 0;
		g[0] = 1;
		int cnt = 0;
		for (int i = 1; i <= n; ++i) {
			prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
			f[i] = f[i - 1];
			g[i] = g[i - 1];
			if ((prefixSum[i] & 1) == 0) {
				cnt = (cnt + f[i - 1]) % MOD;
				g[i]++;
			} else {
				cnt = (cnt + g[i - 1]) % MOD;
				f[i]++;
			}
		}
		return cnt;
	}

}
