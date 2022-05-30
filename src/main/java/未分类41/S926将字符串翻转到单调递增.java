package 未分类41;

public class S926将字符串翻转到单调递增 {

	/**
	 00011
	 最终形成 00000 00001 00011 00111 01111 11111
	 相当于对字符串进行分割，左边=0，右边=1的变换个数
	 定义 f[i]代表i左侧全0的代价
	 */
	public int minFlipsMonoIncr(String s) {
		int n = s.length();
		int[] f = new int[n + 1];
		for (int i = 0; i < n; ++i) {
			f[i + 1] = f[i] + (s.charAt(i) == '1' ? 1 : 0);
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= n; ++i) {
			min = Math.min(min, f[i] + (n - i - (f[n] - f[i])));
		}
		return min;
	}

}
