package dp.依赖前一个状态.状态机.升降;

/**
 计算分别计数山脉从左侧到峰顶升序的个数，从右侧到峰顶升序的个数。最后枚举选出最长山脉
 f 上升
 g 下降
 */
public class S845数组中的最长山脉 {

	public int longestMountain(int[] arr) {
		int n = arr.length;
		int[] f = new int[n];
		int[] g = new int[n];
		for (int i = 1; i < n; ++i) {
			f[i] = arr[i - 1] < arr[i] ? f[i - 1] + 1 : 0;
		}
		for (int i = n - 2; i >= 0; --i) {
			g[i] = arr[i] > arr[i + 1] ? g[i + 1] + 1 : 0;
		}

		int max = 0;
		for (int i = 1; i < n - 1; ++i) {
			if (f[i] > 0 && g[i] > 0) {
				max = Math.max(max, f[i] + g[i] + 1);
			}
		}
		return max;
	}

}
