package 依赖前一个状态.矩阵.零维变量;

/**
 * value[i] + value[j] + i - j = (value[i] + i) + (value[j] - j)
 */
public class S1014最佳观光组合 {

	public int maxScoreSightseeingPair(int[] values) {
		int left = values[0], max = 0;
		for (int i = 1; i < values.length; ++i) {
			max = Math.max(max, left + values[i] - i);
			left = Math.max(left, values[i] + i);
		}
		return max;
	}

}
