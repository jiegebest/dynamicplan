package 依赖前一个状态.区间.回文序列;

public class S1682最长回文子序列II {

	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] f = new int[n][n];
		char[][] g = new char[n][n];

		for (int i = n - 2; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				char ch = s.charAt(i);
				if (ch == s.charAt(j) && (i + 1 == j || g[i + 1][j - 1] != ch)) {
					f[i][j] = f[i + 1][j - 1] + 2;
					g[i][j] = ch;
				} else {
					f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
					g[i][j] = f[i + 1][j] > f[i][j - 1] ? g[i + 1][j] : g[i][j - 1];
				}
			}
		}

		return f[0][n - 1];
	}

}
