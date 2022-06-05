package dp.依赖前所有状态25;

public class S343整数拆分 {

	public int integerBreak(int n) {
		int[] f = new int[n + 1];
		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= i / 2; ++j) {
				f[i] = Math.max(f[i], Math.max(j * (i - j), j * f[i - j]));
			}
		}
		return f[n];
	}

}
