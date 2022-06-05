package dp.依赖前一个状态99.前缀13.划分.交织3;

public class S97交错字符串 {

	public boolean isInterleave(String s1, String s2, String s3) {
		int m = s1.length(), n = s2.length(), t = s3.length();
		if (m + n != t) {
			return false;
		}

		boolean[][] f = new boolean[m + 1][n + 1];
		f[0][0] = true;
		for (int i = 0; i <= m; ++i) {
			for (int j = 0; j <= n; ++j) {
				int p = i + j - 1;
				if (i > 0) {
					f[i][j] = f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p);
				}
				if (j > 0) {
					f[i][j] |= f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p);
				}
			}
		}
		return f[m][n];
	}

}
