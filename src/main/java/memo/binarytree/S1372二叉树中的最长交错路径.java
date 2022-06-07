package memo.binarytree;

import dp.TreeNode;

/**
 后序
 单个节点的路径长度为 0
 空节点的路径长度就是-1  > 这样加和以后，最终的路径长度就等于路径上的节点个数-1
 int[]
 第一个存值放向左下出发的最长长度
 第二个存值放向右下出发的最长长度
 */
public class S1372二叉树中的最长交错路径 {

	int ans = 0;

	public int longestZigZag(TreeNode root) {
		postOrder(root);
		return ans;
	}

	public int[] postOrder(TreeNode node) {
		if (node == null) {
			return new int[]{-1, -1};
		}

		int[] left = postOrder(node.left);
		int[] right = postOrder(node.right);

		ans = Math.max(ans, Math.max(1 + left[1], 1 + right[0]));
		return new int[]{1 + left[1], 1 + right[0]};
	}

}
