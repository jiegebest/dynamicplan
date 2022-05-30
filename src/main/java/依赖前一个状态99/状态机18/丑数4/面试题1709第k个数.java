package 依赖前一个状态99.状态机18.丑数4;

public class 面试题1709第k个数 {

	public int getKthMagicNumber(int k) {
		int[] f = new int[k + 1];
		f[1] = 1;
		int i = 1, j = 1, K = 1;
		for (int p = 2; p <= k; ++k) {
			int a = f[i] * 3;
			int b = f[j] * 5;
			int c = f[K] * 7;
			int min = Math.min(a, Math.min(b, c));
			f[i] = min;
			if (min == a) {
				++i;
			}
			if (min == b) {
				++j;
			}
			if (min == c) {
				++K;
			}
		}
		return f[k];
	}

}
