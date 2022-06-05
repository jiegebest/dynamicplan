package dp.依赖前一个状态99.前缀13.匹配.子串2;

/**
 * 二刷
 */
public class S1638统计只差一个字符的子串数目 {

	public int countSubstrings(String s, String t) {
		int m = s.length();
		int n = t.length();
		int[][] f = new int[m + 1][n + 1];
		int[][] g = new int[m + 1][n + 1];
		int cnt = 0;
		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					f[i][j] = f[i - 1][j - 1] + 1;
					g[i][j] = g[i - 1][j - 1];
				} else {
					f[i][j] = 0;
					g[i][j] = f[i - 1][j - 1] + 1;
				}
				cnt += g[i][j];
			}
		}
		return cnt;
	}

}
