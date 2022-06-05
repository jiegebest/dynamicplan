package dp.依赖前特定状态5.一半3;

public class LCS01下载插件 {

	public int leastMinutes(int n) {
		int[] f = new int[n + 1];
		f[1] = 1;
		for (int i = 2; i <= n; ++i) {
			f[i] = f[(i + 1) / 2] + 1;
		}
		return f[n];
	}

}