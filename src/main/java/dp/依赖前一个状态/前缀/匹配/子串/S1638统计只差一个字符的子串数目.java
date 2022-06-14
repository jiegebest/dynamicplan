package dp.依赖前一个状态.前缀.匹配.子串;

/**
 * 二刷
 * 恰好 只有一个字符不同
 * f 以 i, j 结尾相同子串数目
 * g 以 i, j 结尾差一子串数目
 * 子串
 */
public class S1638统计只差一个字符的子串数目 {

	public int countSubstrings(String s, String t) {
		int m = s.length(), n = t.length();
		int[][] same = new int[m + 1][n + 1];
		int[][] diff = new int[m + 1][n + 1];

		int cnt = 0;
		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					same[i][j] = same[i - 1][j - 1] + 1;
					diff[i][j] = diff[i - 1][j - 1];
				} else {
					same[i][j] = 0;
					diff[i][j] = same[i - 1][j - 1] + 1;
				}
				cnt += diff[i][j];
			}
		}
		return cnt;
	}

}
