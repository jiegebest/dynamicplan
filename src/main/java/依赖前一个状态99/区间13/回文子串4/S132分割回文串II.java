package 依赖前一个状态99.区间13.回文子串4;

import java.util.Arrays;

/**
 * 二刷
 * 两次f
 */
public class S132分割回文串II {

	public int minCut(String s) {
		int n = s.length();
		boolean[][] f = new boolean[n][n];
		for (int i = n - 1; i >= 0; --i) {
			for (int j = i; j < n; ++j) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || f[i + 1][j - 1])) {
					f[i][j] = true;
				}
			}
		}

		int[] g = new int[n];
		Arrays.fill(g, Integer.MAX_VALUE);
		for (int i = 0; i < n; ++i) {
			if (f[0][i]) {
				g[i] = 0;
			} else {
				for (int j = 1; j <= i; ++j) {
					if (f[j][i]) {
						g[i] = Math.min(g[i], g[j - 1] + 1);
					}
				}
			}
		}
		return g[n - 1];
	}

}
