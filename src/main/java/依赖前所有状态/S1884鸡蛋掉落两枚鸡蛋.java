package 依赖前所有状态;

import java.util.Arrays;

public class S1884鸡蛋掉落两枚鸡蛋 {

	/**
	 n层 从i层摔下
	 碎了，尝试次数是 0 1 2 ... i-2 = i-2+1 = i-1 加上第i层的次数 = i-1+1 = i次
	 没碎，尝试次数是 f[n - i] + 1

	 (因为i层及以下不可能摔碎，而0层也不可能摔碎，我们把i层当作是0层，i + 1当作是1层，n - i就是新问题的总层数

	 f 确切的值 每种可能都要覆盖到
	 */
	public int twoEggDrop(int n) {
		int[] f = new int[n + 1];
		Arrays.fill(f, Integer.MAX_VALUE);
		f[0] = 0;

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= i; ++j) {
				f[i] = Math.min(f[i], Math.max(j, f[i - j] + 1));
			}
		}

		return f[n];
	}

}
