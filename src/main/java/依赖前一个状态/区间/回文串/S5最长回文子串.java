package 依赖前一个状态.区间.回文串;

public class S5最长回文子串 {

	public String longestPalindrome(String s) {
		int n = s.length();
		boolean[][] f = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			f[i][i] = true;
		}

		int max = 1, start = 0;
		for (int i = n - 2; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				if (s.charAt(i) == s.charAt(j) && (i + 1 == j || f[i + 1][j - 1])) {
					if ((f[i][j] = true) && j - i + 1 > max) {
						max = j - i + 1;
						start = i;
					}
				}
			}
		}

		return s.substring(start, start + max);
	}

}
