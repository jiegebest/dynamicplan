package dp.依赖前特定状态5.可整除;

import java.util.Arrays;

/**
 * 先拷贝 1 次，在粘贴 j 次
 * j 是最后一次的粘贴个数 (i-j)/j 次数是正整数 i/j - 1 j可以被i整除
 * i/j,说明这个是也是一个合理的底数
 * f[i] 表示打印出 i 个 A 的最少操作次数
 * f[i] = Math.min(f[i], f[j] + 1 + (i - j) / j);
 * f[i] = Math.min(f[i], f[i / j] + 1 + (i - (i / j)) / (i / j));
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
