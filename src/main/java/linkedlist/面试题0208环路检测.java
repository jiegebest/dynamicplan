package linkedlist;

import dp.utils.ListNode;

/**
 * 【当慢指针进入环以后，由于快指针是慢指针速度的两倍。此时无论快指针在哪，都可以在慢指针转完一圈之前赶上。】
 * 因为慢指针走一圈，快指针可以走两圈。他们之间的差距的极限就是一圈。
 * 因为慢指针跑完完整的一圈，但是快指针却不需要跑完完整的两圈。因此一定会在环中某个节点相遇。
 * a 代表起点到环路开头，b 代表环路开头到相遇点，c 代表相遇点到环路开头
 * 【2 * (a + b) = a + b + k * (b + c)】
 * 2a + 2b = a + b + kb + kc
 * a = kr - b = (k - 1) * r + c
 * 所以从 a 到环路开头的时间，c 可以到达环路开头，并且多转 k-1圈。
 * 同时向下移动即可在环路入口相遇
 */
public class 面试题0208环路检测 {

	public ListNode detectCycle(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				ListNode start = head;
				while (start != slow) {
					start = start.next;
					slow = slow.next;
				}
				return start;
			}
		}
		return null;
	}

}
