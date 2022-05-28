package 依赖前一个状态.状态机.丑数;

import java.util.Arrays;

public class S313超级丑数 {

	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] f = new int[n + 1];
		f[1] = 1;

		int m = primes.length;
		int[] index = new int[m];
		Arrays.fill(index, 1);

		for (int i = 2; i <= n; ++i) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < m; ++j) {
				min = Math.min(min, f[index[j]] * primes[j]);
			}
			f[i] = min;
			for (int j = 0; j < m; ++j) {
				if (min == f[index[j]] * primes[j]) {
					++index[j];
				}
			}
		}

		return f[n];
	}

}
