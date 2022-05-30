package 依赖前所有状态25;

/**
 * f[i] 跟 ∑f[i - j] (i % j == 0 && 0 < j < i)
 */
public class S1025除数博弈 {

	public boolean divisorGame(int n) {
		if (n == 1) {
			return false;
		}

		boolean[] f = new boolean[n + 1];
		f[2] = true;
		for (int i = 3; i <= n; ++i) {
			for (int j = 1; j < i; ++j) {
				if (i % j == 0 && !f[i - j]) {
					f[i] = true;
					break;
				}
			}
		}
		return f[n];
	}

}
