package 依赖前所有状态.子序列;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S1218最长定差子序列 {

	// f(i,j) 以i结尾最长等差子序列长度为j
	public int longestSubsequence(int[] arr, int difference) {
		int n = arr.length, max = 1;
		int[] f = new int[n];
		Arrays.fill(f, 1);

		for (int j = 1; j < n; ++j) {
			for (int i = 0; i < j; ++i) {
				if (arr[i] + difference == arr[j]) {
					f[j] = Math.max(f[j], f[i] + 1);
					max = Math.max(max, f[j]);
				}
			}
		}

		return max;
	}

	// 超时,该用哈希表实现 TLE
	public int longestSubsequence1(int[] arr, int difference) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 1;
		for (int num : arr) {
			map.put(num, map.getOrDefault(num - difference, 0) + 1);
			max = Math.max(max, map.get(num));
		}
		return max;
	}

}
