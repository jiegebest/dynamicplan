package 依赖前几个状态.斐波那契数列;

public class 剑指Offer10I斐波那契数列 {

	static final int MOD = 1000000007;

	public int fib(int n) {
		int a = 0, b = 1;
		for (int i = 2; i <= n; ++i) {
			int temp = (a + b) % MOD;
			a = b;
			b = temp;
		}
		return b;
	}

}
