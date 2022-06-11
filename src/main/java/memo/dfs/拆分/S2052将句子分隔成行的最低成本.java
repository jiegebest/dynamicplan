package memo.dfs.拆分;

import java.util.HashMap;
import java.util.Map;

public class S2052将句子分隔成行的最低成本 {

	public int minimumCost(String sentence, int k) {
		String[] chas = sentence.split(" ");
		return dfs(new HashMap<>(), chas, k, chas.length, 0);
	}

	public int dfs(Map<Integer, Integer> cache, String[] sentence, int k, int n, int index) {
		if (index == n) {
			return 0;
		}
		if (cache.containsKey(index)) {
			return cache.get(index);
		}

		int minCost = Integer.MAX_VALUE;
		int len = 0;
		for (int i = index; i <= n; ++i) {
			if (i == n) {
				cache.put(index, 0);
				return 0;
			}
			len += sentence[i].length();
			if (len > k) {
				break;
			}
			int cost = (k - len) * (k - len) + dfs(cache, sentence, k, n, i + 1);
			minCost = Math.min(minCost, cost);
			++len;
		}
		cache.put(index, minCost);
		return cache.get(index);
	}

}
