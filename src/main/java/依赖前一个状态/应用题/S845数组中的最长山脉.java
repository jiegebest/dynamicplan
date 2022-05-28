package 依赖前一个状态.应用题;
/**
 计算分别计数山脉从左侧到峰顶升序的个数，从右侧到峰顶升序的个数。最后枚举选出最长山脉
 */
public class S845数组中的最长山脉 {

	public int longestMountain(int[] arr) {
		int n = arr.length;
		int[] up = new int[n];
		int[] down = new int[n];
		for (int i = 1; i < n; ++i) {
			up[i] = arr[i - 1] < arr[i] ? up[i - 1] + 1 : 0;
		}
		for (int i = n - 2; i >= 0; i--) {
			down[i] = arr[i] > arr[i + 1] ? down[i + 1] + 1 : 0;
		}

		int max = 0;
		for (int i = 1; i < n - 1; ++i) {
			if (up[i] > 0 && down[i] > 0) {
				max = Math.max(max, up[i] + down[i] + 1);
			}
		}
		return max;
	}

}
