package dfscache;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组长度比较短的时候可以用bits
 */
public class S526优美的排列 {

	public int countArrangement(int n) {
		return backtrack(n, 1, 0, new HashMap<>());
	}

	public int backtrack(int n, int index, int bits, Map<Integer, Integer> cache) {
		if (index > n) {
			return 1;
		}
		if (!cache.containsKey(bits)) {
			int cnt = 0;
			for (int i = 1; i <= n; ++i) {
				if (((bits >> i) & 1) == 0 && (i % index == 0 || index % i == 0)) {
					cnt += backtrack(n, index + 1, bits + (1 << i), cache);
				}
			}
			cache.put(bits, cnt);
		}
		return cache.get(bits);
	}

}
