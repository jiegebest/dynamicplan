package memosearch.dfs.括号;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S22括号生成 {

	public List<String> generateParenthesis(int n) {
		Map<Integer, List<String>> map = new HashMap<>();
		return generateAllCombines(n, map);
	}

	public List<String> generateAllCombines(int n, Map<Integer, List<String>> map) {
		if (!map.containsKey(n)) {
			List<String> list = new ArrayList<>();
			if (n == 0) {
				list.add("");
				map.put(0, list);
				return list;
			}
			for (int i = 0; i < n; ++i) {
				for (String s1 : generateAllCombines(i, map)) {
					for (String s2 : generateAllCombines(n - 1 - i, map)) {
						list.add(s1 + "(" + s2 + ")");
					}
				}
			}
			map.put(n, list);
		}
		return map.get(n);
	}

}
