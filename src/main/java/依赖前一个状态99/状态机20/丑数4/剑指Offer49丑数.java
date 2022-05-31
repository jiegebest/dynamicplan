package 依赖前一个状态99.状态机20.丑数4;

public class 剑指Offer49丑数 {

	public int nthUglyNumber(int n) {
		int[] f = new int[n + 1];
		f[1] = 1;
		int i = 1, j = 1, k = 1;
		for (int p = 2; p <= n; ++p) {
			int a = f[i] * 2;
			int b = f[j] * 3;
			int c = f[k] * 5;
			int min = Math.min(a, Math.min(b, c));
			f[p] = min;
			if (min == a) {
				++i;
			}
			if (min == b) {
				++j;
			}
			if (min == c) {
				++k;
			}
		}
		return f[n];
	}

}
