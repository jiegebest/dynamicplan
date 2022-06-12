package dp.依赖前几个状态.斐波那契数列跳台阶爬楼梯;

public class S509斐波那契数 {

	public int fib(int n) {
		if (n == 0) {
			return 0;
		}

		int a = 0, b = 1;
		for (int i = 2; i < n; ++i) {
			int temp = a + b;
			a = b;
			b = temp;
		}
		return b;
	}

}
