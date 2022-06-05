package dp.依赖前所有状态25.子序列3;

public class S873最长的斐波那契子序列的长度 {

	public int lenLongestFibSubseq(int[] arr) {
		int n = arr.length;
		int[][] f = new int[n][n];
		int max = 0;
		for (int k = 2; k < n; ++k) {
			int i = 0, j = k - 1;
			while (i < j) {
				if (arr[i] + arr[j] == arr[k]) {
					f[j][k] = f[i][j] == 0 ? 3 : f[i][j] + 1;
					max = Math.max(max, f[j][k]);
					++i;
					--j;
				} else if (arr[i] + arr[j] < arr[k]) {
					++i;
				} else {
					--j;
				}
			}
		}
		return max;
	}

}
