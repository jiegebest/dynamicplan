package dfscache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 返回所有可能结果 > 方案数 > 所有方案
 回溯 + Map
 回溯的题一般都是在字符串上玩

 优先级虽然不同，但数据处理必须是挨着的
 回溯深搜递归每个符号位置的左右两侧，然后左右两侧的所有可能解集，取笛卡尔积
 */
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
				List<Integer> left = diffWaysToCompute(exp.substring(0, i));
				List<Integer> right = diffWaysToCompute(exp.substring(i + 1));
				for (int num1 : left) {
					for (int num2 : right) {
						list.add(calcExpression(exp.charAt(i), num1, num2));
					}
				}
			}
		}
		return list;
	}

	public int calcExpression(char opt, int num1, int num2) {
		switch(opt) {
			case '+':
				return num1 + num2;
			case '-':
				return num1 - num2;
			case '*':
				return num1 * num2;
			default:
				return -1;
		}
	}


	public boolean isOperation(char c) {
		return c == '+' || c == '-' || c == '*';
	}

}
