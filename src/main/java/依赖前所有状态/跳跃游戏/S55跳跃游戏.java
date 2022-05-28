package 依赖前所有状态.跳跃游戏;

/**
 * 贪心
 */
public class S55跳跃游戏 {

	public boolean canJump(int[] nums) {
		int last = nums.length - 1, best = 0;

		for (int i = 0; i < last; ++i) {
			if (best < i) {
				return false;
			}

			best = Math.max(best, nums[i] + i);
			if (best >= last) {
				return true;
			}
		}

		return last == 0;
	}

}
