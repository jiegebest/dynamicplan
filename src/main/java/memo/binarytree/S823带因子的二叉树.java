package memo.binarytree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S823带因子的二叉树 {

	public int numFactoredBinaryTrees(int[] arr) {
		int MOD = 1_000_000_007;
		int n = arr.length;
		Arrays.sort(arr);
		long[] f = new long[n];
		Arrays.fill(f, 1);

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			map.put(arr[i], i);
		}

		long cnt = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (arr[i] % arr[j] == 0) {
					int num = arr[i] / arr[j];
					if (map.containsKey(num)) {
						f[i] = (f[i] + f[j] * f[map.get(num)]) % MOD;
					}
				}
			}
			cnt = (cnt + f[i]) % MOD;
		}
		return (int) cnt;
	}

}
