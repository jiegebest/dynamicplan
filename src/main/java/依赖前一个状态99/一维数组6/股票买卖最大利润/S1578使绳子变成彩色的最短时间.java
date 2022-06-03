package 依赖前一个状态99.一维数组6.股票买卖最大利润;

/**
 * 思路：相同颜色保留一个移除需要时间最长的一个
 */
public class S1578使绳子变成彩色的最短时间 {

	public int minCost(String colors, int[] neededTime) {
		char[] arr = colors.toCharArray();
		int total = 0;
		for (int i = 1; i < arr.length; ++i) {
			if (arr[i] == arr[i - 1]) {
				total += Math.min(neededTime[i - 1], neededTime[i]);
				if (neededTime[i - 1] > neededTime[i]) {
					neededTime[i] = neededTime[i - 1];
				}
			}
		}
		return total;
	}

}
