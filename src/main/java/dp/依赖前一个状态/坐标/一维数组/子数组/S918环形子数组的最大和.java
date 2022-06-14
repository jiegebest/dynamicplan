package dp.依赖前一个状态.坐标.一维数组.子数组;

/**
 * 非空子数组
 * 邻接数组：环形数组翻一倍展开
 * Math.max(max, sum - min)
 * 极端情况：如果说这数组的所有数都是负数，那么上面的公式还需要变一下，
 * 因为这种情况，对于上面的第一种情况sum会等于数组中的最大值，
 * 而对二种情况sum=0（最小的子数组就是本数组，total-total=0）。
 * 所以多加一个case，判断最大子数组和是否小于0，小于0，直接返回该maxSubArray
 */
public class S918环形子数组的最大和 {

	public int maxSubarraySumCircular(int[] nums) {
		int n = nums.length;
		int[] f = new int[n];
		int[] g = new int[n];
		f[0] = g[0] = nums[0];
		int sum = nums[0];
		int max = nums[0];
		int min = nums[0];

		for (int i = 1; i < n; ++i) {
			sum += nums[i];
			f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
			max = Math.max(max, f[i]);
			g[i] = Math.min(g[i - 1] + nums[i], nums[i]);
			min = Math.min(min, g[i]);
		}

		return max < 0 ? max : Math.max(max, sum - min);
	}

}
