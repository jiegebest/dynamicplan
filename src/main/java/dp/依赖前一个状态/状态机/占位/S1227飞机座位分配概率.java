package dp.依赖前一个状态.状态机.占位;

/**
 状态机
 选中自己 1/n * 1
 选中目标 1/n * 0
 选中其它 n-2/n * f(n-1)
 */
public class S1227飞机座位分配概率 {

	public double nthPersonGetsNthSeat(int n) {
		double prob = 1;
		for (int i = 2; i <= n; ++i) {
			prob = (1.0 + (i - 2) * prob) / i;
		}
		return prob;
	}

}
