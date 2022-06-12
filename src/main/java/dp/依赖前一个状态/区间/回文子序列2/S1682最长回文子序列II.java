package dp.依赖前一个状态.区间.回文子序列2;

public class S1682最长回文子序列II {

	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] f = new int[n][n];
		char[][] g = new char[n][n];
		for (int i = n - 2; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				if (s.charAt(i) == s.charAt(j) && (j - i == 1 || g[i + 1][j - 1] != s.charAt(i))) {
					f[i][j] = f[i + 1][j - 1] + 2;
					g[i][j] = s.charAt(i);
				} else {
					f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
					g[i][j] = f[i + 1][j] > f[i][j - 1] ? g[i + 1][j] : g[i][j - 1];
				}
			}
		}
		return f[0][n - 1];
	}

}
