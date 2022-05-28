package 依赖前一个状态.前缀.匹配.删除;

public class S583两个字符串的删除操作 {

	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] f = new int[m + 1][n + 1];
		for (int i = 1; i <= m; ++i) {
			f[i][0] = i;
		}
		for (int j = 1; j <= n; ++j) {
			f[0][j] = j;
		}

		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					f[i][j] = f[i - 1][j - 1];
				} else {
					f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
				}
			}
		}

		return f[m][n];
	}

}
