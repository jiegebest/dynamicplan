package 依赖前一个状态.状态机.丑数;

public class 剑指Offer49丑数 {

	public int nthUglyNumber(int n) {
		int[] f = new int[n + 1];
		f[1] = 1;
		
		int i = 1, j = 1, k = 1;
		for (int p = 2; p <= n; ++p) {
			int n2 = f[i] * 2;
			int n3 = f[j] * 3;
			int n5 = f[k] * 5;
			int min = Math.min(n2, Math.min(n3, n5));
			f[p] = min;
			if (min == n2) {
				++i;
			}
			if (min == n3) {
				++j;
			}
			if (min == n5) {
				++k;
			}
		}
		
		return f[n];
	}

}
