package 依赖前一个状态.字符串匹配;

public class S97交错字符串 {

	/**
	 f(i, j, k) =
	 f(i - 1, j, k - 1) & (k == i)
	 | f(i, j - 1, k - 1) & (k == i)

	 因为k只与k-1有关，所以这个维度可以降维成一个指针变量 k
	 f(i, j) = f(i - 1, j) & (k == i) | f(i, j - 1) & (k == i)
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		int n = s1.length(), m = s2.length(), s = s3.length();
		if (n + m != s) {
			return false;
		}

		boolean[] f = new boolean[m + 1];
		f[0] = true;

		for (int i = 0; i <= n; ++i) {
			for (int j = 0; j <= m; ++j) {
				int p = i + j - 1;
				if (i > 0) {
					f[j] &= s1.charAt(i - 1) == s3.charAt(p);
				}
				if (j > 0) {
					f[j] |= f[j - 1] && s2.charAt(j - 1) == s3.charAt(p);
				}
			}
		}

		return f[m];
	}

}
