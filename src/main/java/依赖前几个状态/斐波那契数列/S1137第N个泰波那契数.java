package 依赖前几个状态.斐波那契数列;

public class S1137第N个泰波那契数 {

	public int tribonacci(int n) {
		int a = 0, b = 1, c = 1;
		for (int i = 3; i <= n; ++i) {
			int temp = a + b + c;
			a = b;
			b = c;
			c = temp;
		}
		return c;
	}

}
