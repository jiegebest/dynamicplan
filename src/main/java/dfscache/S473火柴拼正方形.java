package dfscache;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 答案不对,还需要调整
 */
public class S473火柴拼正方形 {

	/**
	 状态压缩 回溯DFS+记忆化
	 */
	Map<Integer, Boolean> cache = new HashMap<>();

	public boolean makesquare(int[] matchsticks) {
		int sum = 0, n = matchsticks.length;
		Arrays.sort(matchsticks);
		for (int num : matchsticks) {
			sum += num;
		}
		if (sum % 4 != 0 && matchsticks[n - 1] > sum / 4) {
			return false;
		}

		return backtrack(matchsticks, sum / 4, 0, (1 << n) - 1);
	}

	public boolean backtrack(int[] arr, int square, int bits, int target) {
		if (bits == target) {
			return true;
		}

		if (!cache.containsKey(bits)) {
			boolean canMake = false;
			for (int i = 0; i < arr.length; ++i) {
				int temp = 1 << i;
				if (((bits >> i) & 1) == 0 && (bits % square) + temp <= square) {
					canMake = backtrack(arr, square, bits + temp, target);
					if (canMake) {
						canMake = true;
						break;
					}
				}
			}
			cache.put(bits, canMake);
		}
		return cache.get(bits);
	}

}
