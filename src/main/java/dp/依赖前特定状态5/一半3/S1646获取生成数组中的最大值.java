package dp.依赖前特定状态5.一半3;

public class S1646获取生成数组中的最大值 {

	public int getMaximumGenerated(int n) {
		if (n == 0) {
			return 0;
		}
		int[] f = new int[n + 1];
		f[1] = 1;
		int max = 1;
		for (int i = 2; i <= n; ++i) {
			f[i] = f[i / 2];
			if ((i & 1) == 1) {
				f[i] += f[i / 2 + 1];
			}
			max = Math.max(max, f[i]);
		}
		return max;
	}

}
