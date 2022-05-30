package 依赖前一个状态99.状态机18.子数组;

/**
 * 0-不删
 * 1-删
 */
public class S1186删除一次得到子数组最大和 {

	public int maximumSum(int[] arr) {
		int n = arr.length;
		int[][] f = new int[2][2];
		f[0][0] = arr[0];

		int max = f[0][0];
		for (int i = 1; i < n; ++i) {
			int j = (i - 1) % 2, k = i % 2;
			f[k][0] = Math.max(f[j][0] + arr[i], arr[i]);
			f[k][1] = Math.max(f[j][1] + arr[i], f[j][2]);
			max = Math.max(max, f[k][0]);
			max = Math.max(max, f[k][1]);
		}
		return max;
	}

}
