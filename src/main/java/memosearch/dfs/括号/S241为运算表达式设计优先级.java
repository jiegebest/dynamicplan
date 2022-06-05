package memosearch.dfs.括号;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S241为运算表达式设计优先级 {

	Map<String, List<Integer>> cache = new HashMap<>();

	public List<Integer> diffWaysToCompute(String expression) {
		String exp = expression;
		if (cache.containsKey(exp)) {
			return cache.get(exp);
		}

		List<Integer> list = new ArrayList<>();
		int k = 0, n = exp.length();
		while (k < n && !isOperation(exp.charAt(k))) {
			++k;
		}
		if (k == n) {
			list.add(Integer.valueOf(exp));
			return list;
		}

		for (int i = 1; i < n - 1; ++i) {
			if (isOperation(exp.charAt(i))) {
				for (int n1 : diffWaysToCompute(exp.substring(0, i))) {
					for (int n2 : diffWaysToCompute(exp.substring(i + 1))) {
						list.add(calcExpression(exp.charAt(i), n1, n2));
					}
				}
			}
		}
		return list;
	}

	public int calcExpression(char opt, int n1, int n2) {
		switch(opt) {
			case '+':
				return n1 + n2;
			case '-':
				return n1 - n2;
			case '*':
				return n1 * n2;
			default:
				return -1;
		}
	}

	public boolean isOperation(char c) {
		return c == '+' || c == '-' || c == '*';
	}

}
