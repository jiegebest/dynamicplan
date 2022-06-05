package dp.依赖前一个状态99.状态机40.左右4;

public class S926将字符串翻转到单调递增 {

	public int minFlipsMonoIncr(String s) {
		int n = s.length();
		int[] f = new int[n + 1];
		int[] g = new int[n + 1];
		for (int i = 0; i < n; ++i) {
			if (s.charAt(i) == '0') {
				g[0]++;
			}
		}

		int min = g[0];
		for (int i = 1; i <= n; ++i) {
			if (s.charAt(i - 1) == '0') {
				f[i] = f[i - 1];
				g[i] = g[i - 1] - 1;
			} else {
				f[i] = f[i - 1] + 1;
				g[i] = g[i - 1];
			}
			min = Math.min(min, f[i] + g[i]);
		}
		return min;
	}

}
