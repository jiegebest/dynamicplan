package dp.依赖前一个状态.背包.完全背包7;

import java.util.Arrays;

public class S279完全平方数 {

	public int numSquares(int n) {
		int[] f = new int[n + 1];
		Arrays.fill(f, n + 1);
		f[0] = 0;

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j * j <= i; ++j) {
				f[i] = Math.min(f[i], f[i - j * j]);
			}
			++f[i];
		}
		return f[n];
	}

}
