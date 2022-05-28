package 依赖前一个状态.矩阵.零维变量;

public class 剑指Offer63股票的最大利润 {

	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE, max = 0;
		for (int price : prices) {
			min = Math.min(min, price);
			max = Math.max(max, price - min);
		}
		return max;
	}

}
