package tree;

import dp.utils.TreeNode;

/**
 * 最大路径和 > dp
 * dp[i] = max(dp[i-1], 0) + nums[i]
 * 还有个max变量跟踪当前最值
 *
    最大路径和需要取经过所有节点的最大路径和的max
    向上返回只返回一条最长路径
 */
public class S124二叉树中的最大路径和 {

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		getMax(root);
		return max;
	}

	// 计算二叉树中的一个节点的最大贡献值. 在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大。
	public int getMax(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = Math.max(0, getMax(root.left));
		int right = Math.max(0, getMax(root.right));
		int sum = left + root.val + right;
		max = Math.max(max, sum);
		return Math.max(root.val + left, root.val + right);
	}

}