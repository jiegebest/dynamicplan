package 依赖前一个状态.应用题;

public class LCP07传递信息 {

	public int numWays(int n, int[][] relation, int k) {
		int[][] f = new int[k + 1][n];
		f[0][0] = 1;
		for (int i = 0; i < k; ++i) {
			for (int[] arr : relation) {
				int src = arr[0], dest = arr[1];
				f[i + 1][dest] += f[i][src];
			}
		}
		return f[k][n - 1];
	}

}
