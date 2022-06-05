package dp.依赖前一个状态99.状态机40.左右4;

import java.util.ArrayList;
import java.util.List;
/**
 从左到右 非递增
 从右到左 非递增
 */
public class S2100适合打劫银行的日子 {

	public List<Integer> goodDaysToRobBank(int[] security, int time) {
		int n = security.length;
		int[] left = new int[n];
		int[] right = new int[n];

		for (int i = 1; i < n; ++i) {
			if (security[i - 1] >= security[i]) {
				left[i] = left[i - 1] + 1;
			}
		}
		for (int i = n - 2; i >= 0; --i) {
			if (security[i] <= security[i + 1]) {
				right[i] = right[i + 1] + 1;
			}
		}

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			if (left[i] >= time && right[i] >= time) {
				res.add(i);
			}
		}
		return res;
	}

}
