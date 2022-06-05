package dp.依赖前几个状态19.跳台阶爬楼梯5;

public class 面试题0801三步问题 {

	static final int MOD = 1000000007;

	public int waysToStep(int n) {
		int a = 1, b = 1, c = 1;
		for (int i = 3; i <= n; ++i) {
			c = ((a + b) % MOD + c) % MOD;
		}
		return c;
	}

}
