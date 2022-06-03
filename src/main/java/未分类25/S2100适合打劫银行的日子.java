package 未分类25;

import java.util.ArrayList;
import java.util.List;

public class S2100适合打劫银行的日子 {

	// 依赖前一个状态，记录i前多少天非递增，后多少天非递减.
	public List<Integer> goodDaysToRobBank(int[] security, int time) {
		int n = security.length;
		int[] left = new int[n], right = new int[n];
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

		List<Integer> list = new ArrayList<>();
		for (int i = time; i < n - time; ++i) {
			if (left[i] >= time && right[i] >= time) {
				list.add(i);
			}
		}
		return list;
	}

}
