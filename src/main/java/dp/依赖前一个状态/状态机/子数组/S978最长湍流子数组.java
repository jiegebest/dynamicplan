package dp.依赖前一个状态.状态机.子数组;

import java.util.Arrays;

/**
 * 0-升
 * 1-降
 * 这道题无所谓奇偶，主要是升降必须连续起来，此起彼伏
 */
public class S978最长湍流子数组 {

	public int maxTurbulenceSize(int[] arr) {
		int n = arr.length;
		int[] up = new int[n];
		int[] down = new int[n];
		Arrays.fill(up, 1);
		Arrays.fill(down, 1);

		int max = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i - 1] > arr[i]) {
				down[i] = up[i - 1] + 1;
				max = Math.max(max, down[i]);
			} else if (arr[i - 1] < arr[i]) {
				up[i] = down[i - 1] + 1;
				max = Math.max(max, up[i]);
			}
		}
		return max;
	}

}
