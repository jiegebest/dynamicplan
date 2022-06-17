package dp.状压;

import java.util.HashMap;
import java.util.Map;

/**
 * DFS + memo
 * 数组本身不同于单个数字可以直接用于索引，因此需要将数组进行处理
 * 这道题的数据范围是 1 \le n \le 71≤n≤7 和 1 \le m \le 71≤m≤7，因此 nn 位的 m+1m+1 进制数最大为 7777777_{(8)}
 * 8 进制的状压
 */
public class S1908Nim游戏II {

	public boolean nimGame(int[] piles) {
		int max = 0;
		for (int pile : piles) {
			max = Math.max(max, pile);
		}
		++max;

		int n = piles.length;
		int[] bases = new int[n];
		bases[0] = 1;
		for (int i = 1; i < n; ++i) {
			bases[i] = bases[i - 1] * max;
		}
		int num = 0;
		for (int i = 0; i < n; ++i) {
			num += bases[i] * piles[i];
		}

		Map<Integer, Boolean> cache = new HashMap<>();
		cache.put(0, false);
		return dp(bases, cache, n, num);
	}

	public boolean dp(int[] bases, Map<Integer, Boolean> cache, int n, int state) {
		if (cache.containsKey(state)) {
			return cache.get(state);
		}

		int[] piles = new int[n];
		int replica = state;
		for (int i = n - 1; i >= 0; --i) {
			piles[i] = replica / bases[i];
			replica %= bases[i];
		}

		boolean currWin = false;
		for (int i = 0; i < n && !currWin; ++i) {
			for (int j = 1; j <= piles[i]; ++j) {
				boolean nextWin = dp(bases, cache, n, state - j * bases[i]);
				if (!nextWin) {
					currWin = true;
					break;
				}
			}
		}
		cache.put(state, currWin);
		return currWin;
	}

}
