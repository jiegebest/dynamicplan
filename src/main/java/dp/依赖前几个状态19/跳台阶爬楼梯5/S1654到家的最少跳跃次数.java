package dp.依赖前几个状态19.跳台阶爬楼梯5;

import java.util.HashSet;

/**
 * 可正跳一次，可正跳一次倒跳一次
 * 跳两次，第一次向前跳不要求在数组内
 */
public class S1654到家的最少跳跃次数 {

	public int minimumJumps(int[] forbidden, int a, int b, int x) {
		if (x == 0) {
			return 0;
		}
		HashSet<Integer> set = new HashSet<>();
		for (int num : forbidden) {
			set.add(num);
		}

		int[] f = new int[4001];
		int n = f.length;
		for (int i = 0; i < n; ++i) {
			if (set.contains(i) || (i != 0 && f[i] == 0)) {
				continue;
			}

			int next = i + a;
			if (!set.contains(next) && next < n && (f[next] == 0 || f[next] > f[i] + 1)) {
				f[next] = f[i] + 1;
			}

			int back = next - b;
			if (!set.contains(next) && !set.contains(back) && 0 <= back && back < n && (f[back] == 0 || f[back] > f[i] + 2)) {
				f[back] = f[i] + 2;
				if (b > a) {
					i = back - 1;
				}
			}
		}
		return f[x] == 0 ? -1 : f[x];
	}

}
