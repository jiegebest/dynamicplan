package dp.memo.binarytree;

import dp.utils.TreeNode;

/**
 * 非常经典
 * 1. 最大 BST 子树数量
 * 2. 中序判断子树是否为 BST
 * 3. 计算子树节点数量
 */
public class S333最大BST子树 {

	TreeNode prev = null;

	public int largestBSTSubtree(TreeNode root) {
		prev = null;
		if (root == null) {
			return 0;
		}
		if (isBST(root)) {
			return cnt(root);
		}
		return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
	}

	public boolean isBST(TreeNode node) {
		if (node == null) {
			return true;
		}
		if (!isBST(node.left)) {
			return false;
		}
		if (prev != null && prev.val >= node.val) {
			return false;
		}
		prev = node;
		return isBST(node.right);
	}

	public int cnt(TreeNode node) {
		return node == null ? 0 : cnt(node.left) + 1 + cnt(node.right);
	}

}









