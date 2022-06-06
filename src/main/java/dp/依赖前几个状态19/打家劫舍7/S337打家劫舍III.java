package dp.依赖前几个状态19.打家劫舍7;


import dp.TreeNode;

/**
 * 为了避免重复计算，采用后序遍历
 */
public class S337打家劫舍III {

	public int rob(TreeNode root) {
		int[] answer = postOrder(root);
		return Math.max(answer[0], answer[1]);
	}

	public int[] postOrder(TreeNode node) {
		if (node == null) {
			return new int[]{0, 0};
		}

		int[] left = postOrder(node.left);
		int[] right = postOrder(node.right);

		int choose = node.val + left[1] + right[1];
		int notChoose = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return new int[]{choose, notChoose};
	}

}
