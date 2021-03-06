package dp.memo.dfs.游戏;

import java.util.HashMap;
import java.util.Map;

public class S464我能赢吗 {

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
			return false;
		}
		return dfs(maxChoosableInteger, 0, desiredTotal, 0, new HashMap<>());
	}

	public boolean dfs(int max, int bits, int total, int current, Map<Integer, Boolean> cache) {
		if (!cache.containsKey(bits)) {
			boolean canWin = false;
			for (int i = 1; i <= max; ++i) {
				if (((bits >> i) & 1) == 0) {
					if (current + i >= total || !dfs(max, bits | (1 << i), total, current + i, cache)) {
						canWin = true;
						break;
					}
				}
			}
			cache.put(bits, canWin);
		}
		return cache.get(bits);
	}

}
