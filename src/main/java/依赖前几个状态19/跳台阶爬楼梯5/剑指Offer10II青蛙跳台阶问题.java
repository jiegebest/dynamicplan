package 依赖前几个状态19.跳台阶爬楼梯5;

public class 剑指Offer10II青蛙跳台阶问题 {

	static final int MOD = 1000000007;

	public int numWays(int n) {
		int a = 1, b = 1;
		for (int i = 2; i <= n; ++i) {
			int temp = (a + b) % MOD;
			a = b;
			b = temp;
		}
		return b;
	}

}
