package 依赖前所有状态.左右划分;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 面试题0809括号 {

	public List<String> generateParenthesis(int n) {
		Map<Integer, List<String>> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		list.add("");
		map.put(0, list);

		for (int i = 1; i <= n; ++i) {
			list = new ArrayList<>();
			for (int j = 0; j < i; ++j) {
				List<String> left = map.get(j);
				List<String> right = map.get(i - 1 - j);
				for (String str1 : left) {
					for (String str2 : right) {
						list.add(str1 + "(" + str2 + ")");
					}
				}
			}
			map.put(i, list);
		}
		return map.get(n);
	}

}
