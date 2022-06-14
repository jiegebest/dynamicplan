package dp.依赖前一个状态.区间.回文子串;

public class S5最长回文子串 {

	public String longestPalindrome(String s) {
		int n = s.length();
		boolean[][] f = new boolean[n][n];
		int maxLen = 1, start = 0;
		for (int i = n - 1; i >= 0; --i) {
			for (int j = i; j < n; ++j) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || f[i + 1][j - 1])) {
					f[i][j] = true;
					if (j - i + 1 > maxLen) {
						maxLen = j - i + 1;
						start = i;
					}
				}
			}
		}
		return s.substring(start, start + maxLen);
	}

}
