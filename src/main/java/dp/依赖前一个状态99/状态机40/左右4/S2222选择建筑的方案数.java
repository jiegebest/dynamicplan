package dp.依赖前一个状态99.状态机40.左右4;

/**
 * 建筑 相邻 的两栋不能是同一类型，相邻，就是跟左右有关。那么我们可以采用中心线枚举的办法。
 * 找 1 扩展两边 0 的次数的笛卡尔积。或者找到 0，扩展两边 1 的次数的笛卡尔积。遍历的过程中，左右可复用
 */
public class S2222选择建筑的方案数 {

	public long numberOfWays(String s) {
		int n = s.length(), zero = 0, one = 0;
		for (int i = 0; i < n; ++i) {
			if (s.charAt(i) == '0') {
				++zero;
			}
		}
		one = n - zero;

		long cnt = 0, leftZero = zero, leftOne = one;
		for (int i = 1; i <= n; ++i) {
			if (s.charAt(i - 1) == '0') {
				--leftZero;
				cnt += leftOne * (one - leftOne);
			} else {
				--leftOne;
				cnt += leftZero * (zero - leftZero);
			}
		}
		return cnt;
	}

}
