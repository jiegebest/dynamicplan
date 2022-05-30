package 依赖前一个状态99.前缀13.匹配.子串2;

public class S1062最长重复子串 {

	public int longestRepeatingSubstring(String s) {
		int n = s.length();
		int[][] f = new int[n][n];
		int max = 0;
		for (int i = 0; i < n - 1; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (s.charAt(i) == s.charAt(j)) {
					f[i][j] = 1;
					if (i > 0) {
						f[i][j] = f[i - 1][j - 1] + 1;
					}
					max = Math.max(max, f[i][j]);
				}
			}
		}
		return max;
	}

}
