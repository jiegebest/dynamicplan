package dp.依赖前几个状态.斐波那契数列跳台阶爬楼梯;

public class S70爬楼梯 {

	public int climbStairs(int n) {
		int a = 1, b = 2;
		for (int i = 3; i <= n; ++i) {
			int temp = a + b;
			a = b;
			b = temp;
		}
		return b;
	}

}
