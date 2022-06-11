package dp.状压;

import java.util.HashMap;
import java.util.Map;

/**
 匹配
 1 <= m <= 8
 状态压缩
 遍历 students 的时候，memtors 的选择情况就可以表示出来
 */
public class S1947最大兼容性评分和 {

	public int maxCompatibilitySum(int[][] students, int[][] mentors) {
		return dfs(new HashMap<>(), students, 0, mentors, 0);
	}

	public int dfs(Map<Integer, Integer> cache, int[][] students, int index, int[][] mentors, int state) {
		if (index == students.length) {
			return 0;
		}
		if (cache.containsKey(state)) {
			return cache.get(state);
		}

		int max = 0;
		for (int i = 0; i < mentors.length; ++i) {
			if (((1 << i) & state) == 0) {
				int grade = 0;
				for (int j = 0; j < mentors[0].length; ++j) {
					if (students[index][j] == mentors[i][j]) {
						++grade;
					}
				}
				int rest = dfs(cache, students, index + 1, mentors, state | (1 << i));
				max = Math.max(max, grade + rest);
			}
		}
		cache.put(state, max);
		return max;
	}

}
