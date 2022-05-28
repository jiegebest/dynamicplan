package 依赖前一个状态.区间.回文串;

public class S剑指OfferII020回文子字符串的个数 {

	public int countSubstrings(String s) {
		int n = s.length();
		boolean[][] f = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			f[i][i] = true;
		}

		int cnt = n;
		for (int i = n - 2; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				if (s.charAt(i) == s.charAt(j) && (i + 1 == j || f[i + 1][j - 1])) {
					if (f[i][j] = true) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

}
