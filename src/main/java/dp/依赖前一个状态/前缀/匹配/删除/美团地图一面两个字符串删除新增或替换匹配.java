package dp.依赖前一个状态.前缀.匹配.删除;

public class 美团地图一面两个字符串删除新增或替换匹配 {

	public int getMinCount(String word1, String word2) {
		if (word1 == null && word2 == null) {
			return 0;
		}
		if (word1 == null) {
			return word2.length();
		}
		if (word2 == null) {
			return word1.length();
		}

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
					f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
				}
			}
		}

		return f[m][n];
	}

}












