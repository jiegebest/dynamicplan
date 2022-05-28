package 依赖前所有状态.左右划分;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S22括号生成 {

	/**
	 把一对抽出去，n-1对再拆成两部分ab
	 圈0个 ()ab a()b ab()
	 圈1个 (a)b a(b)
	 圈2个 (ab)
	 a 或 b 都有可能为空
	 a 为"" ()ab == a()b == (a)b == ()b == b == (b) == (ab)
	 b 为"" a(b) == ab() == a() == a
	 而 a == b 所以以上6种情况都能被划分出来
	 */
	public List<String> generateParenthesis(int n) {
		Map<Integer, List<String>> map = new HashMap<>();
		return generateAllCombines(n, map);
	}

	public List<String> generateAllCombines(int n, Map<Integer, List<String>> map) {
		if (map.containsKey(n)) {
			return map.get(n);
		}

		List<String> list = new ArrayList<>();
		if (n == 0) {
			list.add("");
			map.put(0, list);
			return list;
		}

		for (int i = 0; i < n; ++i) {
			List<String> list1 = generateAllCombines(i, map);
			List<String> list2 = generateAllCombines(n - 1 - i, map);
			for (String s1 : list1) {
				for (String s2 : list2) {
					list.add(s1 + "(" + s2 + ")");
				}
			}
		}
		map.put(n, list);
		return list;
	}

}
