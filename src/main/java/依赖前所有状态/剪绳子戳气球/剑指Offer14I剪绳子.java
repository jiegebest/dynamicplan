package 依赖前所有状态.剪绳子戳气球;

public class 剑指Offer14I剪绳子 {

	public int cuttingRope(int n) {
		int[] f = new int[n + 1];
		f[1] = 1;
		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j < i; ++j) {
				int bigger = j * Math.max(i - j, f[i - j]);
				f[i] = Math.max(f[i], bigger);
			}
		}
		return f[n];
	}

}
