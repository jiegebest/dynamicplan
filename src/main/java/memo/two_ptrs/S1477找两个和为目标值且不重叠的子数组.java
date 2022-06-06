package memo.two_ptrs;

/**
 * 非常经典 好题 双指针滑动窗口+DP
 * f[i] 以 i 结尾的最小长度，这样找两个，就是最小和最小以前的。
 */
public class S1477找两个和为目标值且不重叠的子数组 {

	static final int INF = Integer.MAX_VALUE / 2;

	public int minSumOfLengths(int[] arr, int target) {
		int n = arr.length;
		int[] f = new int[n];
		f[0] = arr[0] == target ? 1 : INF;

		int left = 0, right = 0, sum = 0, min = INF;
		while (right < n) {
			if (right > 0) {
				f[right] = f[right - 1];
			}
			sum += arr[right];
			while (sum >= target) {
				if (sum == target) {
					int len = right - left + 1;
					f[right] = Math.min(f[right], len);
					if (left > 0) {
						min = Math.min(min, f[left - 1] + len);
					}
				}
				sum -= arr[left];
				++left;
			}
			++right;
		}

		return min >= INF ? -1 : min;
	}

}
