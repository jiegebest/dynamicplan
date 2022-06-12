package dp.依赖前一个状态.状态机.子数组7;

/**
 * 0-升序
 * 1-降序
 */
public class S978最长湍流子数组 {

	public int maxTurbulenceSize(int[] arr) {
		int n = arr.length;
		int[][] f = new int[n][2];
		f[0][0] = f[0][1] = 1;

		int max = 1;
		for (int i = 1; i < n; i++) {
			f[i][0] = f[i][1] = 1;
			if (arr[i - 1] > arr[i]) {
				f[i][1] = f[i - 1][0] + 1;
				max = Math.max(max, f[i][1]);
			} else {
				f[i][0] = f[i - 1][1] + 1;
				max = Math.max(max, f[i][0]);
			}
		}
		return max;
	}

}
