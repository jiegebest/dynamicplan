package 依赖前几个状态.打家劫舍;

public class S740删除并获得点数 {

	/**
	 相当于选了 i 就不能选 i- 1和 i+1，跟打家劫舍同理
	 选完 nums[i]后，nums[i]-1和nums[i]+1也被删除，所以多个值=nums[i]的最后只能是将点数加和
	 */
	public int deleteAndEarn(int[] nums) {
		int max = nums[0];
		for (int num : nums) {
			max = Math.max(max, num);
		}

		int[] arr = new int[max + 1];
		for (int num : nums) {
			arr[num] += num;
		}

		int a = arr[0], b = Math.max(arr[0], arr[1]);
		for (int i = 2; i <= max; ++i) {
			int temp = Math.max(a + arr[i], b);
			a = b;
			b = temp;
		}
		return b;
	}

}
