package dp.依赖前一个状态.状态机.子序列;

/**
 * 状态机
 * odd[i]   奇数下标结尾最大和
 * even[i] 偶数下标结尾最大和
 * f[i] 代表以当前元素结尾的子序列最大和
 * 1 <= nums[i] <= 105 数字都是正数，所以直接取 even[n - 1] 就可以
 * 注意数据类型是 long
 */
public class S1911最大子序列交替和 {

	public long maxAlternatingSum(int[] nums) {
		int n = nums.length;
		long[] odd = new long[n];
		long[] even = new long[n];
		odd[0] = 0;
		even[0] = nums[0];
		for (int i = 1; i < n; ++i) {
			odd[i] = Math.max(odd[i - 1], even[i - 1] - nums[i]);
			even[i] = Math.max(even[i - 1], odd[i - 1] + nums[i]);
		}
		return even[n - 1];
	}

}
