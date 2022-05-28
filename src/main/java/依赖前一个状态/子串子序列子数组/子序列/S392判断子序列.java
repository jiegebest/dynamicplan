package 依赖前一个状态.子串子序列子数组.子序列;

public class S392判断子序列 {

	public boolean isSubsequence(String s, String t) {
		int n = s.length(), m = t.length();
		boolean[][] f = new boolean[n + 1][m + 1];

		for (int i = 0; i <= m; ++i) {
			f[0][i] = true;
		}

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				f[i][j] = f[i][j - 1] || f[i - 1][j - 1] && s.charAt(i - 1) == t.charAt(j - 1);
			}
		}

		return f[n][m];
	}

}
