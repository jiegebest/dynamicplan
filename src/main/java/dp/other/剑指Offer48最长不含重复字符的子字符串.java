package dp.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 未优化逻辑
 * 注意：并不知道这个字符的范围，不能默认全是小写字母。所以要用 map 存储，而不是哈希数组
 */
public class 剑指Offer48最长不含重复字符的子字符串 {

	// 合并 if 分支之后的
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> cache = new HashMap<>();
		int maxLen = 0, currLen = 0;
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (cache.containsKey(c) && i - cache.get(c) <= currLen) {
				currLen = i - cache.get(c);
			} else {
				maxLen = Math.max(maxLen, ++currLen);
			}
			cache.put(c, i);
		}
		return maxLen;
	}

	// public int lengthOfLongestSubstring(String s) {
	// 	Map<Character, Integer> cache = new HashMap<>();
	// 	int maxLen = 0, currLen = 0;
	// 	for (int i = 0; i < s.length(); ++i) {
	// 		char c = s.charAt(i);
	// 		if (cache.containsKey(c)) {
	// 			if (i - cache.get(c) > currLen) {
	// 				maxLen = Math.max(maxLen, ++currLen);
	// 			} else {
	// 				currLen = i - cache.get(c);
	// 			}
	// 		} else {
	// 			maxLen = Math.max(maxLen, ++currLen);
	// 		}
	// 		cache.put(c, i);
	// 	}
	// 	return maxLen;
	// }

}
