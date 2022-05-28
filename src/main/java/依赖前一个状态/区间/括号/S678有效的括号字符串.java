package 依赖前一个状态.区间.括号;

/**
 *
 */
public class S678有效的括号字符串 {

	// 好题，不简单呐 拆+不拆
	public boolean checkValidString(String s) {
		int n = s.length();
		if (n == 1) {
			return s.charAt(0) == '*';
		}

		boolean[][] f = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			if (s.charAt(i) == '*') {
				f[i][i] = true;
			}
		}

		for (int i = n - 2; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				char c1 = s.charAt(i), c2 = s.charAt(j);
				if ((c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*')) {
					f[i][j] = i + 1 == j || f[i + 1][j - 1];
				}
				for (int k = i; k < j && !f[i][j]; ++k) {
					f[i][j] = f[i][k] && f[k + 1][j];
				}
			}
		}

		return f[0][n - 1];
	}

}
