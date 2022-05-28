package dfscache;

import 未分类.basic.TreeNode;

public class S333最大BST子树 {

	int ans = 0;

	public int largestBSTSubtree(TreeNode root) {
		dfs(root);
		return ans;
	}

	/**
	 * 自底向上，树形f
	 *
	 * 返回 [min,max,size] 则 root 是非空BST
	 * 返回 []             则 root 是空BST
	 * 返回 null           则 root 不是 BST
	 */
	int[] dfs(TreeNode root) {
		if (root == null) return new int[0];
		int[] L = dfs(root.left), R = dfs(root.right);
		// 左右子树必须为BST
		if (L == null || R == null) return null;
		// 节点值必须大于左子树的最大值
		if (L.length == 3 && root.val <= L[1]) return null;
		// 节点值必须小于右子树的最小值
		if (R.length == 3 && root.val >= R[0]) return null;
		int min = root.val, max = root.val, size = 1;
		if (L.length == 3) {
			min = L[0];
			size += L[2];
		}
		if (R.length == 3) {
			max = R[1];
			size += R[2];
		}
		ans = Math.max(ans, size);
		return new int[]{min, max, size};
	}

}
