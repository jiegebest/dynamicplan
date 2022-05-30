package 依赖前几个状态19.斐波那契数列4;

public class S746使用最小花费爬楼梯 {

	public int minCostClimbingStairs(int[] cost) {
		int a = 0, b = 0;
		for (int i = 2; i <= cost.length; ++i) {
			int temp = Math.min(a + cost[i - 2], b + cost[i - 1]);
			a = b;
			b = temp;
		}
		return b;
	}

}
