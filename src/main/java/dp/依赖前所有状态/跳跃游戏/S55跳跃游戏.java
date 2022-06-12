package dp.依赖前所有状态.跳跃游戏;

/**
 * 贪心
 */
public class S55跳跃游戏 {

	public boolean canJump(int[] nums) {
		int last = nums.length - 1, max = 0;
		for (int i = 0; i < last; ++i) {
			if (max < i) {
				return false;
			}
			max = Math.max(max, nums[i] + i);
			if (max >= last) {
				return true;
			}
		}
		return last == 0;
	}

}
