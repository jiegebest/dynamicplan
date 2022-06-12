package dp.依赖前一个状态.状态机.子序列;

/**
 * 状态机
 *
 * odd[i]   奇数下标结尾最大和
 * even[i] 偶数下标结尾最大和
 */
public class S1911最大子序列交替和 {

	public long maxAlternatingSum(int[] nums) {
		int n = nums.length;
		long[] odd = new long[n];
		long[] even = new long[n];
		odd[0] = 0;
		even[0] = nums[0];

		for (int i = 1; i < n; ++i) {
			// 最后一个选择的下标是奇数，要-
			odd[i] = Math.max(odd[i - 1], even[i - 1] - nums[i]);
			// 最后一个选择的下标是偶数，要+
			even[i] = Math.max(even[i - 1], odd[i - 1] + nums[i]);
		}

		return even[n - 1];
	}

}
