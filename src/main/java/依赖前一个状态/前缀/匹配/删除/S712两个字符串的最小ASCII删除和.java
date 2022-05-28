package 依赖前一个状态.前缀.匹配.删除;

public class S712两个字符串的最小ASCII删除和 {

	public int minimumDeleteSum(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] f = new int[m + 1][n + 1];
		for (int i = 1; i <= m; ++i) {
			f[i][0] = f[i - 1][0] + s1.charAt(i - 1);
		}
		for (int j = 1; j <= n; ++j) {
			f[0][j] = f[0][j - 1] + s2.charAt(j - 1);
		}

		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				char c1 = s1.charAt(i - 1);
				char c2 = s2.charAt(j - 1);
				if (c1 == c2) {
					f[i][j] = f[i - 1][j - 1];
				} else {
					f[i][j] = Math.min(f[i - 1][j] + c1, f[i][j - 1] + c2);
				}
			}
		}

		return f[m][n];
	}

}
