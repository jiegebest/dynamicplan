package dfscache;

import java.util.HashMap;
import java.util.Map;

/**
 回溯
 如果是++，创建新串，改成--，就不用还原了
 一个为true即为true
 */
public class S294翻转游戏II {

	Map<String, Boolean> cache = new HashMap<>();

	public boolean canWin(String currentState) {
		if (cache.containsKey(currentState)) {
			return cache.get(currentState);
		}

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

		return false;
	}

}
