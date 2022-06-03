package 未分类25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S638大礼包 {

	/**
	 可先选择任意一种大礼包，然后减掉库存，递归的进行后续操作
	 礼包可以以任意顺序买，可以买任意多次
	 所以是回溯
	 */
	// needs组合的最低价格，也就是目标解
	Map<List<Integer>, Integer> cache = new HashMap<>();

	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		int n = price.size();
		// 过滤不合理的大礼包
		List<List<Integer>> validSpecial = new ArrayList<>();
		for (List<Integer> gift : special) {
			// 不能购买超出购物清单指定数量的物品
			int i = 0;
			while (i < n) {
				if (gift.get(i) > needs.get(i)) {
					break;
				}
				++i;
			}
			if (i != n) {
				continue;
			}

			// 去掉空礼包和昂贵礼包
			int count = 0, cost = 0;
			for (int j = 0; j < n; ++j) {
				count += gift.get(j);
				cost += gift.get(j) * price.get(j);
			}
			if (count > 0 && cost > gift.get(n)) {
				validSpecial.add(gift);
			}
		}

		return backtrack(price, validSpecial, needs, n);
	}

	public int backtrack(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int n) {
		if (!cache.containsKey(needs)) {
			int minCost = 0;
			for (int i = 0; i < n; ++i) {
				minCost += price.get(i) * needs.get(i);
			}
			for (List<Integer> curr : special) {
				int specialPrice = curr.get(n);
				List<Integer> stillNeeds = new ArrayList<>();
				// 礼包每一个数量都得小于 needs
				for (int i = 0; i < n; ++i) {
					if (curr.get(i) > needs.get(i)) {
						break;
					}
					stillNeeds.add(needs.get(i) - curr.get(i));
				}
				if (stillNeeds.size() == n) {
					int cost = specialPrice + backtrack(price, special, stillNeeds, n);
					minCost = Math.min(minCost, cost);
				}
			}
			cache.put(needs, minCost);
		}
		return cache.get(needs);
	}

}
