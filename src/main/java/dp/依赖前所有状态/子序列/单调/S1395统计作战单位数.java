package dp.依赖前所有状态.子序列.单调;

/**
 * 子序列
 * 有两个状态：上升，下降
 * 单调序列或者等差序列，只看最后两个元素
 * 如果判断 j 到 i 是升序或降序，将 up[j]或 down[j]的值加入最终计数中
 */
public class S1395统计作战单位数 {

	public int numTeams(int[] rating) {
		int n = rating.length;
		int[] up = new int[n];
		int[] down = new int[n];
		if (rating[0] < rating[1]) {
			up[1] = 1;
		} else {
			down[1] = 1;
		}

		int total = 0;
		for (int i = 2; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (rating[j] < rating[i]) {
					total += up[j];
					++up[i];
				} else {
					total += down[j];
					++down[i];
				}
			}
		}
		return total;
	}

}
