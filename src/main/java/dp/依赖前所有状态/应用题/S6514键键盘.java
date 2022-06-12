package dp.依赖前所有状态.应用题;

/**
 * 最后一步是加法或者乘法
 * f[j] 代表前 j 步的最大操作结果, j+1 进行 ctrla, j+2 进行 ctrlc, j+3 进行 ctrlv, 因此 j+2<i & j >=1的，没有第一步，就没有基数
 * f[j] * (i - j - 2 + 1代表要翻倍) = i - j - 1
 */
public class S6514键键盘 {

	public int maxA(int n) {
		int[] f = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			f[i] = f[i - 1] + 1;
			for (int j = 1; j + 2 < i; ++j) {
				f[i] = Math.max(f[i], f[j] * (i - j - 1));
			}
		}
		return f[n];
	}

}











