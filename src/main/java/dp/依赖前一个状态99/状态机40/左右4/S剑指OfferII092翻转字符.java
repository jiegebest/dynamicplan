package dp.依赖前一个状态99.状态机40.左右4;

/**
 * 状态机 左右状态拆分
 * f[i] 缝隙 i 索引左边全 0 代价
 * f[j] 缝隙 j 索引右边全 1 代价
 */
public class S剑指OfferII092翻转字符 {

	public int minFlipsMonoIncr(String s) {
		int n = s.length();
		int[] f = new int[n + 1];
		int[] g = new int[n + 1];
		f[0] = 0;
		for (int i = 0; i < n; ++i) {
			if (s.charAt(i) == '0') {
				++g[0];
			}
		}

		int min = f[0] + g[0];
		for (int i = 1; i <= n; ++i) {
			if (s.charAt(i - 1) == '0') {
				f[i] = f[i - 1];
				g[i] = g[i - 1] - 1;
			} else {
				g[i] = g[i - 1];
				f[i] = f[i - 1] + 1;
			}
			min = Math.min(min, f[i] + g[i]);
		}
		return min;
	}

}
