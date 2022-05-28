package 依赖前特定规则状态.不定长;

import java.util.HashSet;

public class S1654到家的最少跳跃次数 {

	// 可正跳一次，可正跳一次倒跳一次
	// 跳两次，第一次向前跳不要求在数组内
	public int minimumJumps(int[] forbidden, int a, int b, int x) {
		if (x == 0) {
			return 0;
		}

		HashSet<Integer> set = new HashSet<>();
		for (int num : forbidden) {
			set.add(num);
		}

		int[] f = new int[4001];
		for (int i = 0; i < f.length; ++i) {
			if (set.contains(i) || (i != 0 && f[i] == 0)) {
				continue;
			}
			int next = i + a, back = next - b;
			if (!set.contains(next) && next < f.length
					&& (f[next] == 0 || f[next] > f[i] + 1)) {
				f[next] = f[i] + 1;
			}
			if (!set.contains(next) && !set.contains(back)
					&& back >= 0 && back < f.length
					&& (f[back] == 0 || f[back] > f[i] + 2)) {
				f[back] = f[i] + 2;
				i = b > a ? back - 1 : i;
			}
		}
		return f[x] == 0 ? -1 : f[x];
	}

}
