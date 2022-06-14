package dp.依赖前一个状态.背包._01背包.变形.加减;

/**
 最终重量 = +- a求和
 (a + b + c) 最接近 d + e + f
 题目转变成了找出其中一组,其和与另一组最为接近
 差值即为最终值

 找出一堆数字和最接近sum/2
 */
public class S1049最后一块石头的重量II {

	public int lastStoneWeightII(int[] stones) {
		int sum = 0;
		for (int weight : stones) {
			sum += weight;
		}

		int m = sum / 2;
		boolean[] f = new boolean[m + 1];
		f[0] = true;
		for (int weight : stones) {
			for (int i = m; i >= weight; --i) {
				f[i] |= f[i - weight];
			}
		}

		for (int i = m; i >= 0; --i) {
			if (f[i]) {
				return sum - 2 * i;
			}
		}
		return 0;
	}

}
