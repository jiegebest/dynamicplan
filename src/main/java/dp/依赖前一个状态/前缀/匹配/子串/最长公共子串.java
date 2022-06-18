package dp.依赖前一个状态.前缀.匹配.子串;

/**
 * abac dabc
 * => ab
 * 子串连续
 * f[i][j] 以 s1 以i-1结尾,  s2 以 j-1 结尾的最长公共子串的长度
 * 因为是以 i 结尾，因为结果需要收集全域
 */
public class 最长公共子串 {

	public String longestSubString(String s1, String s2) {
		int max = 0, m = s1.length(), n = s2.length();
		String str = "";
		int[][] f = new int[m + 1][n + 1];
		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						f[i][j] = f[i - 1][j - 1] + 1;
						if (f[i][j] > max) {
							max = f[i][j];
							str = s1.substring(i - f[i][j], i );
						}
				}
			}
		}
		return str;
	}

}
