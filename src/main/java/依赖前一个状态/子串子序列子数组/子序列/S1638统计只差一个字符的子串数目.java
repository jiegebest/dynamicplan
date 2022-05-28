package 依赖前一个状态.子串子序列子数组.子序列;

public class S1638统计只差一个字符的子串数目 {

	/**
	 两个串 公共子序列 先把一样的找出来，然后再变化
	 f [公共子序列]+一个不同字符对可以形成目标序列组合
	 g[i][j] 代表包含i，j位置的目标子字符串组合数
	 */
	public int countSubstrings(String s, String t) {
		int sn = s.length(), tn = t.length();
		int[][] f = new int[sn + 1][tn + 1];
		int[][] g = new int[sn + 1][tn + 1];


		for (int i = 1; i <= sn; ++i) {
			for (int j = 1; j <= tn; ++j) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					g[i][j] = g[i - 1][j - 1];
					f[i][j] = f[i - 1][j - 1] + 1;
				} else {
					g[i][j] = f[i - 1][j - 1] + 1;
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= sn; ++i) {
			for (int j = 1; j <= tn; ++j) {
				ans += g[i][j];
			}
		}
		return ans;
	}

}
