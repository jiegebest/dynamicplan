package 依赖前一个状态99.一维数组6.最大子数组和;

/**
 * 邻接数组：环形数组翻一倍展开
 * Math.max(max, sum - min)
 *
 * 极端情况：如果说这数组的所有数都是负数，那么上面的公式还需要变一下，
 * 因为这种情况，对于上面的第一种情况sum会等于数组中的最大值，
 * 而对二种情况sum=0（最小的子数组就是本数组，total-total=0）。
 * 所以多加一个case，判断最大子数组和是否小于0，小于0，直接返回该maxSubArray
 */
public class S918环形子数组的最大和 {

	static final int INF = Integer.MAX_VALUE / 2;

	public int maxSubarraySumCircular(int[] nums) {
		int total = 0;
		int maxSum = -INF, currMax = 0;
		int minSum = INF, currMin = 0;

		for (int num : nums) {
			currMax = Math.max(currMax + num, num);
			maxSum = Math.max(maxSum, currMax);
			currMin = Math.min(currMin + num, num);
			minSum = Math.min(minSum, currMin);
			total += num;
		}

		return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
	}

}
