package dfsmemo6;

import java.util.*;

public class S140单词拆分II {

	public List<String> wordBreak(String s, List<String> wordDict) {
		Map<Integer, List<List<String>>> cache = new HashMap<>();
		HashSet<String> dict = new HashSet<>(wordDict);
		List<List<String>> wordsList = backtrack(s, cache, dict, 0, new LinkedList<>());

		List<String> res = new ArrayList<>();
		for (List<String> words : wordsList) {
			res.add(String.join(" ", words));
		}
		return res;
	}

	public List<List<String>> backtrack(String s, Map<Integer, List<List<String>>> cache,
	                                    Set<String> dict, int index, List<String> words) {
		if (!cache.containsKey(index)) {
			List<List<String>> wordsList = new LinkedList<>();
			if (index == s.length()) {
				wordsList.add(new LinkedList<>(words));
			}
			for (int i = index + 1; i <= s.length(); ++i) {
				String word = s.substring(index, i);
				if (dict.contains(word)) {
					List<List<String>> suffixList = backtrack(s, cache, dict, i, words);
					for (List<String> list : suffixList) {
						LinkedList<String> temp = new LinkedList<>(list);
						temp.addFirst(word);
						wordsList.add(temp);
					}
				}
			}
			cache.put(index, wordsList);
		}
		return cache.get(index);
	}

}
