package dp.依赖前一个状态.前缀.匹配.交织;

/**
 * 不能使用双指针的原因在于,当s1和s2都命中时,不知道该移动上面还是下面的指针,都要考虑
 */
public class S剑指OfferII096字符串交织 {

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
				if (i > 0 && s1.charAt(i - 1) == s3.charAt(p)) {
					f[i][j] = f[i - 1][j];
				}
				if (j > 0 && s2.charAt(j - 1) == s3.charAt(p)) {
					f[i][j] |= f[i][j - 1];
				}
			}
		}
		return f[m][n];
	}

}
