package 依赖前一个状态.区间.回文串;

import java.util.Arrays;

/**
 * 二刷
 * 两次f
 */
public class S132分割回文串II {

	public int minCut(String s) {
		int n = s.length();
		boolean[][] f = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			f[i][i] = true;
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; ++j) {
				if (s.charAt(i) == s.charAt(j) && (i + 1 == j || f[i + 1][j - 1])) {
					f[i][j] = true;
				}
			}
		}

		int[] g = new int[n];
		Arrays.fill(g, Integer.MAX_VALUE);
		for (int i = 0; i < n; ++i) {
			if (f[0][i]) {
				g[i] = 0;
				continue;
			}
			for (int j = 1; j <= i; ++j) {
				if (f[j][i]) {
					g[i] = Math.min(g[i], g[j - 1] + 1);
				}
			}
		}
		return g[n - 1];
	}

}
