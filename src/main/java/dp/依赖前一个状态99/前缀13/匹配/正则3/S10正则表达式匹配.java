package dp.依赖前一个状态99.前缀13.匹配.正则3;

/**
 * ab*表示第一位的 a后面可以出现0个或多个b
 * 不用a*匹配0个 f[i][j] = f[i][j - 2];
 * 用a*匹配一个或者多个.匹配一个就等于匹配多个 f[i][j] |= f[i - 1][j];
 */
public class S10正则表达式匹配 {

	public boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		boolean[][] f = new boolean[m + 1][n + 1];
		f[0][0] = true;

		for (int i = 0; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (p.charAt(j - 1) == '*') {
					f[i][j] = f[i][j - 2];
					if (matches(s, p, i, j - 1)) {
						f[i][j] |= f[i - 1][j];
					}
				} else {
					if (matches(s, p, i, j)) {
						f[i][j] = f[i - 1][j - 1];
					}
				}
			}
		}
		return f[m][n];
	}

	public boolean matches(String s, String p, int i, int j) {
		if (i == 0) {
			return false;
		}
		return p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1);
	}

}
