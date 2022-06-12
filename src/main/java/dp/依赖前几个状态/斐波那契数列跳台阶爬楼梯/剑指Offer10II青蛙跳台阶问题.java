package dp.依赖前几个状态.斐波那契数列跳台阶爬楼梯;

public class 剑指Offer10II青蛙跳台阶问题 {

	public int numWays(int n) {
		int a = 1, b = 1, MOD = 1_000_000_007;
		for (int i = 2; i <= n; ++i) {
			int temp = (a + b) % MOD;
			a = b;
			b = temp;
		}
		return b;
	}

}
