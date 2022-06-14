package dp.依赖前一个状态.前缀.匹配.子序列;

public class S392判断子序列 {

	public boolean isSubsequence(String s, String t) {
		int m = s.length(), n = t.length();
		boolean[][] f = new boolean[m + 1][n + 1];
		for (int j = 0; j <= n; ++j) {
			f[0][j] = true;
		}

		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					f[i][j] = f[i - 1][j - 1];
				} else {
					f[i][j] = f[i][j - 1];
				}
			}
		}

		return f[m][n];
	}

}
