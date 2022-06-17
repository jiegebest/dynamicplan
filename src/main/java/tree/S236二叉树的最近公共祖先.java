package tree;

import dp.utils.TreeNode;

/**
 * 返回目标节点
 * 返回捕获的公共节点个数
 */
public class S236二叉树的最近公共祖先 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Result res = postOrder(root, p, q);
		return res.node;
	}

	public Result postOrder(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return new Result(0, null);
		}

		Result left = postOrder(root.left, p, q);
		if (left.sum == 2) {
			return left;
		}
		Result right = postOrder(root.right, p, q);
		if (right.sum == 2) {
			return right;
		}

		int sum = left.sum + right.sum + (root == p || root == q ? 1 : 0);
		return new Result(sum, root);
	}

}

class Result {
	public int sum = 0;
	public TreeNode node = null;

	public Result() {
	}

	public Result(int sum, TreeNode node) {
		this.sum = sum;
		this.node = node;
	}
}