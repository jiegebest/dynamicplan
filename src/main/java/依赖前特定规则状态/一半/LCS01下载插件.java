package 依赖前特定规则状态.一半;

public class LCS01下载插件 {

	// 策略：先加宽带后下载
	public int leastMinutes(int n) {
		int[] f = new int[n + 1];
		f[1] = 1;
		for (int i = 2; i <= n; ++i) {
			f[i] = f[(i + 1) / 2] + 1;
		}
		return f[n];
	}

}
