package dp.依赖前一个状态.坐标.一维数组.前面保留一个数值;

/**
 * 思路：相同颜色保留一个移除需要时间最长的一个
 */
public class S1578使绳子变成彩色的最短时间 {

	public int minCost(String colors, int[] neededTime) {
		char[] chars = colors.toCharArray();
		int minTime = 0;
		for (int i = 1; i < chars.length; ++i) {
			if (chars[i] != chars[i - 1]) {
				continue;
			}
			if (neededTime[i - 1] <= neededTime[i]) {
				minTime += neededTime[i - 1];
			} else {
				minTime += neededTime[i];
				neededTime[i] = neededTime[i - 1];
			}
		}
		return minTime;
	}

}
