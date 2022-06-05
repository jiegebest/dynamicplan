package memosearch.dfs.游戏;

import java.util.HashMap;
import java.util.Map;

public class S294翻转游戏II {

	Map<String, Boolean> cache = new HashMap<>();

	public boolean canWin(String currentState) {
		if (!cache.containsKey(currentState)) {
			for (int i = 0; i < currentState.length() - 1; ++i) {
				if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
					char[] chas = currentState.toCharArray();
					chas[i] = chas[i + 1] = '-';
					String str = new String(chas);
					if (canWin(str)) {
						cache.put(str, true);
					} else {
						cache.put(str, false);
						return true;
					}
				}
			}
			cache.put(currentState, false);
		}
		return cache.get(currentState);
	}

}
