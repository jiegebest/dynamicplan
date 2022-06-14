package dp.依赖前一个状态.区间.回文子串;

public class S剑指OfferII020回文子字符串的个数 {

	public int countSubstrings(String s) {
		int n = s.length();
		boolean[][] f = new boolean[n][n];
		int cnt = n;
		for (int i = n - 1; i >= 0; --i) {
			for (int j = i; j < n; ++j) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || f[i + 1][j - 1])) {
					if (f[i][j] = true) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

}
