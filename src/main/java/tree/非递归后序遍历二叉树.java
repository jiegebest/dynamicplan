package tree;

import dp.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 非递归后序遍历二叉树 {

	/**
	 栈
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			// res.add(node.val);
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}
		return res;
	}

}
