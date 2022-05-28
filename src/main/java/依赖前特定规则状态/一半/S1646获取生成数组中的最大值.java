package 依赖前特定规则状态.一半;

public class S1646获取生成数组中的最大值 {

	public int getMaximumGenerated(int n) {
		if (n == 0) {
			return 0;
		}

		int[] f = new int[n + 1];
		f[1] = 1;
		int max = 1;
		for (int i = 2; i <= n; ++i) {
			int half = i / 2;
			if ((i & 1) == 0) {
				f[i] = f[half];
			} else {
				f[i] = f[half] + f[half + 1];
			}
			max = Math.max(max, f[i]);
		}
		return max;
	}

}
