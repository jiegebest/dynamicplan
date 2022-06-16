package linkedlist;

import dp.utils.ListNode;

/**
 * 1 <= left <= right <= n
 * left可能等于 right
 * 拆 反 串
 */
public class S92反转链表II {

	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null || head.next == null || left == right) {
			return head;
		}

		// 1. 标记
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p = dummy, p1 = null, p2 = null, p3 = null, p4 = null;
		int i = 0;
		while (p != null) {
			if (i == left - 1) {
				p1 = p;
			} else if (i == left) {
				p2 = p;
			} else if (i == right) {
				p3 = p;
			} else if (i == right + 1) {
				p4 = p;
			}
			p = p.next;
			++i;
		}

		// 2. 截断
		if (p1 != null) {
			p1.next = null;
		}
		if (p3 != null) {
			p3.next = null;
		}

		// 3. 反转
		reverse(p2);

		// 4. 连接
		if (p1 != null) {
			p1.next = p3;
		}
		if (p2 != null) {
			p2.next = p4;
		}

		return dummy.next;
	}

	public void reverse(ListNode node) {
		ListNode prev = null, curr = node;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
	}

}
