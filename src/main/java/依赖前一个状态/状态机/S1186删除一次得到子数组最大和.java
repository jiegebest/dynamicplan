package 依赖前一个状态.状态机;

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
			int prev = (i - 1) % 2, curr = i % 2;
			f[curr][0] = Math.max(f[prev][0] + arr[i], arr[i]);
			f[curr][1] = Math.max(f[prev][1] + arr[i], f[prev][2]);
			max = Math.max(max, f[curr][0]);
			max = Math.max(max, f[curr][1]);
		}
		return max;
	}

}
