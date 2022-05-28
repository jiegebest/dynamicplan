package 依赖前一个状态.子串子序列子数组.子序列;

public class 剑指OfferII095最长公共子序列 {

	// f(i,j)代表以i，j结尾的两个字符串的最长子序列长度
	public int longestCommonSubsequence(String text1, String text2) {
		int n = text1.length(), m = text2.length();
		int[][] f = new int[n + 1][m + 1];
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					f[i][j] = f[i - 1][j - 1] + 1;
				} else {
					f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
				}
			}
		}
		return f[n][m];
	}

}
