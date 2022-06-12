package dp.依赖前特定状态.特定规则;

import java.util.Deque;
import java.util.LinkedList;

/**
 * k 很大的，整多重循环肯定超时
 */
public class S1696跳跃游戏VI {

	public int maxResult(int[] nums, int k) {
		int n = nums.length;
		int[] f = new int[n];
		f[0] = nums[0];
		Deque<Integer> queue = new LinkedList<>();
		queue.offer(0);

		for (int i = 1; i < n; ++i) {
			f[i] = f[queue.peekFirst()] + nums[i];
			if (queue.peekFirst() + k <= i) {
				queue.pollFirst();
			}
			while (!queue.isEmpty() && f[queue.peekLast()] <= f[i]) {
				queue.pollLast();
			}
			queue.offer(i);
		}

		return f[n - 1];
	}

}
