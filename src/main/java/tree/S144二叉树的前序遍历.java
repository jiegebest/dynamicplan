package tree;

import dp.utils.TreeNode;

import java.util.*;

/**
 * 非递归遍历二叉树：栈
 * 左中右
 * 先放入最左 弹出 放入右子节点最左
 * 压栈时收集 > 前序, 出栈时收集 > 中序
 */
public class S144二叉树的前序遍历 {

	/*
		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> res = new ArrayList<>();
			preOrder(res, root);
			return res;
		}

		public void preOrder(List<Integer> res, TreeNode root) {
			if (root == null) {
				return;
			}
			res.add(root.val);
			preOrder(res, root.left);
			preOrder(res, root.right);
		}
	 */

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				res.add(p.val);
				p = p.left;
			}
			p = stack.pop();
			p = p.right;
		}
		return res;
	}

}
