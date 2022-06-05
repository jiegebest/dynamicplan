package dp.依赖前一个状态99.前缀13.匹配.子序列3;

public class 剑指OfferII095最长公共子序列 {

	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int[][] f = new int[m + 1][n + 1];
		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					f[i][j] = f[i - 1][j - 1] + 1;
				} else {
					f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
				}
			}
		}
		return f[m][n];
	}

}
