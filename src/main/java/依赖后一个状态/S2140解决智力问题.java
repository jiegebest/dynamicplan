package 依赖后一个状态;

/**
 * 反方向定义状态
 * 二刷
 * 跳过 不跳过
 */
public class S2140解决智力问题 {

	public long mostPoints(int[][] questions) {
		int n = questions.length;
		long[] f = new long[n];
		f[n - 1] = questions[n - 1][0];
		long max = f[n - 1];
		for (int i = n - 2; i >= 0; --i) {
			int prev = i + questions[i][1] + 1;
			f[i] = Math.max(f[i + 1], questions[i][0] + (prev < n ? f[prev] : 0));
			max = Math.max(max, f[i]);
		}
		return max;
	}

}
