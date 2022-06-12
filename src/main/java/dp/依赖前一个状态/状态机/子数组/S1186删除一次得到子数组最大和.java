package dp.依赖前一个状态.状态机.子数组;

/**
 * 0-不删
 * 1-删
 * 返回它的某个 非空 子数组
 */
public class S1186删除一次得到子数组最大和 {

	public int maximumSum(int[] arr) {
		int n = arr.length;
		int[] noDelete = new int[n];
		int[] delete = new int[n];
		noDelete[0] = arr[0];

		int max = noDelete[0];
		for (int i = 1; i < n; ++i) {
			noDelete[i] = Math.max(noDelete[i - 1] + arr[i], arr[i]);
			delete[i] = Math.max(delete[i - 1] + arr[i], noDelete[i - 1]);
			max = Math.max(max, Math.max(noDelete[i], delete[i]));
		}
		return max;
	}

}
