package dfscache;

import java.util.HashMap;
import java.util.Map;

public class S464我能赢吗 {

	Map<Integer, Boolean> cache = new HashMap<>();

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		int max = maxChoosableInteger;
		if ((1 + max) * max / 2 < desiredTotal) {
			return false;
		}
		return dfs(max, 0, desiredTotal, 0);
	}

	public boolean dfs(int max, int bitCount, int total, int current) {
		if (cache.containsKey(bitCount)) {
			return cache.get(bitCount);
		}

		boolean canWin = false;
		for (int i = 0; i < max; ++i) {
			if (((bitCount >> i) & 1) == 1) {
				continue;
			}
			if (current + (i + 1) >= total
				|| !dfs(max, bitCount | (1 << i), total, current + (i + 1))) {
				canWin = true;
				break;
			}
		}
		cache.put(bitCount, canWin);
		return canWin;
	}

}
