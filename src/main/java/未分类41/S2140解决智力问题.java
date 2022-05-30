package 未分类41;

public class S2140解决智力问题 {

	/**
	 fi是到当前位置（之前的）最高分数,而不确定是否包含当前元素。所以f不能初始化为当前元素
	 分跳过和不跳过两种
	 */
	public long mostPoints(int[][] questions) {
		int n = questions.length;
		long[] f = new long[n + 1];

		for (int i = 0; i < n; ++i) {
			// 跳过(只能跳过一个)
			f[i + 1] = Math.max(f[i + 1], f[i]);
			// 不跳过
			int j = Math.min(i + 1 + questions[i][1], n);
			f[j] = Math.max(f[j], f[i] + questions[i][0]);
		}

		return f[n];
	}

}
