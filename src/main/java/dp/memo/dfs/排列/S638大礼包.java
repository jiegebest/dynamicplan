package dp.memo.dfs.排列;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. DFS
 * 2. 记忆化搜索
 */
public class S638大礼包 {

	Map<List<Integer>, Integer> cache = new HashMap<>();

	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		if (cache.containsKey(needs)) {
			return cache.get(needs);
		}

		int n = price.size();
		int totalPrice = 0;
		for (int i = 0; i < n; ++i) {
			totalPrice += price.get(i) * needs.get(i);
		}

		for (List<Integer> gift : special) {
			List<Integer> clone = new ArrayList<>(needs);
			boolean isValid = true;
			for (int i = 0; i < n; ++i) {
				if (clone.get(i) < gift.get(i)) {
					isValid = false;
					break;
				}
				clone.set(i, clone.get(i) - gift.get(i));
			}
			if (isValid) {
				totalPrice = Math.min(totalPrice, gift.get(n) + shoppingOffers(price, special, clone));
			}
		}
		cache.put(needs, totalPrice);
		return totalPrice;
	}

}
