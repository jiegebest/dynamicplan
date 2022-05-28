package 依赖前一个状态.子串子序列子数组.子串;

import java.util.HashMap;
import java.util.Map;

public class S3无重复字符的最长子串 {

	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int n = s.length();
		int[] f = new int[n + 1];

		for (int i = 1; i <= n; ++i) {
			char ch = s.charAt(i - 1);
			if (map.containsKey(ch)) {
				int d = i - map.get(ch);
				f[i] = d <= f[i - 1] ? d : f[i - 1] + 1;
			} else {
				f[i] = f[i - 1] + 1;
			}
			map.put(ch, i);
		}

		int max = 0;
		for (int len : f) {
			max = Math.max(max, len);
		}
		return max;
	}

}
