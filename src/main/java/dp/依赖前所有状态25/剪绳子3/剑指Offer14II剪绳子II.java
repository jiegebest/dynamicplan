package dp.依赖前所有状态25.剪绳子3;

import java.math.BigInteger;

/**
 * 可拆可不拆，拆大不拆小
 */
public class 剑指Offer14II剪绳子II {

	static final BigInteger MOD = BigInteger.valueOf(1000000007);

	public int cuttingRope(int n) {
		BigInteger[] f = new BigInteger[n + 1];
		f[1] = f[2] = BigInteger.ONE;
		for (int i = 3; i <= n; ++i) {
			long half = i / 2, rest = i - half;
			f[i] = BigInteger.valueOf(half * rest);
			for (int j = 2; j <= half; ++j) {
				f[i] = f[i].max(f[i - j].multiply(BigInteger.valueOf(j)));
			}
		}
		return f[n].mod(MOD).intValue();
	}

}
