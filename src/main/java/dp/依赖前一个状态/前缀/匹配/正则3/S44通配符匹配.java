package dp.依赖前一个状态.前缀.匹配.正则3;

public class S44通配符匹配 {

	public boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		boolean[][] f = new boolean[m + 1][n + 1];
		f[0][0] = true;
		for (int i = 1; i <= n; ++i) {
			if (p.charAt(i - 1) != '*') {
				break;
			}
			f[0][i] = true;
		}

		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				char c1 = s.charAt(i - 1);
				char c2 = p.charAt(j - 1);
				if (c1 == c2 || c2 == '?') {
					f[i][j] = f[i - 1][j - 1];
				} else if (c2 == '*') {
					f[i][j] = f[i][j - 1] || f[i - 1][j];
				}
			}
		}
		return f[m][n];
	}

}
