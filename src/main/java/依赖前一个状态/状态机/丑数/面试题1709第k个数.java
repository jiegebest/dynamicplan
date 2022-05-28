package 依赖前一个状态.状态机.丑数;

public class 面试题1709第k个数 {

	public int getKthMagicNumber(int k) {
		int[] f = new int[k + 1];
		f[1] = 1;
		
		int p = 1, q = 1, r = 1;
		for (int i = 2; i <= k; ++i) {
			int n1 = f[p] * 3;
			int n2 = f[q] * 5;
			int n3 = f[r] * 7;
			int min = Math.min(n1, Math.min(n2, n3));
			f[i] = min;
			if (min == n1) {
				++p;
			}
			if (min == n2) {
				++q;
			}
			if (min == n3) {
				++r;
			}
		}

		return f[k];
	}

}
