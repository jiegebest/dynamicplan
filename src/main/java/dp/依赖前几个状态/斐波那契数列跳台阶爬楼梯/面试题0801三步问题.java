package dp.依赖前几个状态.斐波那契数列跳台阶爬楼梯;

public class 面试题0801三步问题 {

	public int waysToStep(int n) {
		int a = 1, b = 1, c = 1, MOD = 1_000_000_007;
		for (int i = 3; i <= n; ++i) {
			c = ((a + b) % MOD + c) % MOD;
		}
		return c;
	}

}
