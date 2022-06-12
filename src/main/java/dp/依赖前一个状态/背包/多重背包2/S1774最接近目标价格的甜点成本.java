package dp.依赖前一个状态.背包.多重背包2;

/**
 * 多重背包
 */
public class S1774最接近目标价格的甜点成本 {

	public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		int n = 20000;
		boolean[] f = new boolean[n + 1];
		for (int base : baseCosts) {
			f[base] = true;
		}

		for (int i = 0; i < 2; ++i) {
			for (int topping : toppingCosts) {
				for (int j = n; j > topping; --j) {
					f[j] |= f[j - topping];
				}
			}
		}

		int closest = n, minCost = n;
		for (int i = n - 1; i > 0; --i) {
			if (f[i]) {
				int distance = Math.abs(i - target);
				if (distance <= closest) {
					closest = distance;
					minCost = i;
				}
			}
		}
		return minCost;
	}

}
