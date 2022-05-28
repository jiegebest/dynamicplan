package 依赖前一个状态.矩阵.零维变量;

public class S121买卖股票的最佳时机 {

	public int maxProfit(int[] prices) {
		int curr = Integer.MAX_VALUE, max = 0;
		for (int price : prices) {
			curr = Math.min(curr, price);
			max = Math.max(max, price - curr);
		}
		return max;
	}

}
