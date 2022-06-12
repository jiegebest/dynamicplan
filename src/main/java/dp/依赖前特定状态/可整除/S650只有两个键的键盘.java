package dp.依赖前特定状态.可整除;

import java.util.Arrays;

/**
 * 恰好，就说明必须是整数倍
 */
public class S650只有两个键的键盘 {

	public int minSteps(int n) {
		int[] f = new int[n + 1];
		Arrays.fill(f, Integer.MAX_VALUE);
		f[1] = 0;

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j * j <= i; ++j) {
				if (i % j == 0) {
					int k = i / j;
					f[i] = Math.min(f[i], f[j] + k);
					f[i] = Math.min(f[i], f[k] + j);
				}
			}
		}

		return f[n];
	}

}
