package dp.依赖前几个状态.斐波那契数列跳台阶爬楼梯;

public class 剑指Offer10I斐波那契数列 {

	public int fib(int n) {
		int a = 0, b = 1, MOD = 1_000_000_007;
		for (int i = 2; i <= n; ++i) {
			int temp = (a + b) % MOD;
			a = b;
			b = temp;
		}
		return b;
	}

}
