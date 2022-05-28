package 依赖前几个状态.跳台阶爬楼梯;

public class 剑指Offer10II青蛙跳台阶问题 {

	public int numWays(int n) {
		int a = 1, b = 1;
		for (int i = 2; i <= n; ++i) {
			int temp = (a + b) % 1000000007;
			a = b;
			b = temp;
		}
		return b;
	}

}
