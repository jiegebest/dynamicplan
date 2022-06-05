package dp.依赖前几个状态19.打家劫舍7;

public class S740删除并获得点数 {

	public int deleteAndEarn(int[] nums) {
		int max = nums[0];
		for (int num : nums) {
			max = Math.max(max, num);
		}

		int[] arr = new int[max + 1];
		for (int num : nums) {
			arr[num] += num;
		}

		int a = arr[0];
		int b = Math.max(arr[0], arr[1]);
		for (int i = 2; i <= max; ++i) {
			int temp = Math.max(a + arr[i], b);
			a = b;
			b = temp;
		}
		return b;
	}

}
