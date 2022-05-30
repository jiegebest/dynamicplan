package 依赖前一个状态99.过程模拟1;

public class LCP07传递信息 {

	public int numWays(int n, int[][] relation, int k) {
		int[][] f = new int[k + 1][n];
		f[0][0] = 1;
		for (int i = 1; i <= k; ++i) {
			for (int[] arr : relation) {
				f[i][arr[1]] += f[i - 1][arr[0]];
			}
		}
		return f[k][n - 1];
	}

}
