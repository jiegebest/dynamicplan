package 依赖前一个状态.区间.回文序列;

public class S516最长回文子序列 {

	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] f = new int[n][n];
		for (int i = 0; i < n; ++i) {
			f[i][i] = 1;
		}

		for (int i = n - 2; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				if (s.charAt(i) == s.charAt(j)) {
					f[i][j] = i + 1 == j ? 2 : f[i + 1][j - 1] + 2;
				} else {
					f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
				}
			}
		}

		return f[0][n - 1];
	}

}
