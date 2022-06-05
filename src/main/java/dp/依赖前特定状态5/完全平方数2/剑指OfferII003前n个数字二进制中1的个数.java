package dp.依赖前特定状态5.完全平方数2;

public class 剑指OfferII003前n个数字二进制中1的个数 {

	public int[] countBits(int n) {
		int[] f = new int[n + 1];
		int high = 0;
		for (int i = 1; i <= n; ++i) {
			if ((i & (i - 1)) == 0) {
				f[i] = 1;
				high = i;
			} else {
				f[i] = f[i - high] + 1;
			}
		}
		return f;
	}

}
