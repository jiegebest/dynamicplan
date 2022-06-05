package dp.依赖前一个状态99.状态机40.丑数4;

import java.util.Arrays;

public class S313超级丑数 {

	public int nthSuperUglyNumber(int n, int[] primes) {
		int m = primes.length;
		int[] g = new int[m];
		Arrays.fill(g, 1);
		int[] f = new int[n + 1];
		f[1] = 1;

		for (int i = 2; i <= n; ++i) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < m; ++j) {
				min = Math.min(min, f[g[j]] * primes[j]);
			}
			f[i] = min;
			for (int j = 0; j < m; ++j) {
				if (min == f[g[j]] * primes[j]) {
					++g[j];
				}
			}
		}

		return f[n];
	}

}
