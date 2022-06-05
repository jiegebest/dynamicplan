package dp.依赖前几个状态19.统计学规律1;

/**
 * n = 0      1
 * n = 1      1 + 9
 * n = 2      1 + 9 + 9 * 9
 * n = 3      1 + 9 + 9 * 9 + 9 * 9 * 8
 * n = 4      1 + 9 + 9 * 9 + 9 * 9 * 8 + 9 * 9 * 8 * 7
 */
public class S357统计各位数字都不同的数字个数 {

	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}

		int[] f = new int[n + 1];
		f[0] = 1;
		f[1] = 10;

		for (int i = 2; i <= n; ++i) {
			f[i] = f[i - 1] + (f[i - 1] - f[i - 2]) * (11 - i);
		}
		return f[n];
	}

}
