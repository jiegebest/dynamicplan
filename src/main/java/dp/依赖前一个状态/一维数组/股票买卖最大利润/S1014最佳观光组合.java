package dp.依赖前一个状态.一维数组.股票买卖最大利润;

/**
 * 对于每一个j,查找所有 0-j-1
 * (value[i] + i) + (value[j]  - j)
 */
public class S1014最佳观光组合 {

	public int maxScoreSightseeingPair(int[] values) {
		int left = values[0], max = 0;
		for (int j = 1; j < values.length; ++j) {
			max = Math.max(max, left + values[j] - j);
			left = Math.max(left, values[j] + j);
		}
		return max;
	}

}
