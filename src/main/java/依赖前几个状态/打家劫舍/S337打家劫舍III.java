package 依赖前几个状态.打家劫舍;


import 未分类.basic.TreeNode;

public class S337打家劫舍III {

	// 为了避免重复计算，采用后序遍历
	// 每个子树要返回当前节点选和不选得到的最高金额两个数据
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
