package 依赖前一个状态.状态机.丑数;

public class S264丑数II {

	public int nthUglyNumber(int n) {
		int[] f = new int[n + 1];
		f[1] = 1;

		int p = 1, q = 1, r = 1;
		for (int k = 2; k <= n; ++k) {
			int n2 = f[p] * 2;
			int n3 = f[q] * 3;
			int n5 = f[r] * 5;
			int min = Math.min(n2, Math.min(n3, n5));
			f[k] = min;
			if (min == n2) {
				++p;
			}
			if (min == n3) {
				++q;
			}
			if (min == n5) {
				++r;
			}
		}

		return f[n];
	}

}
