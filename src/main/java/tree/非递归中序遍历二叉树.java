package tree;

import dp.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 非递归遍历二叉树：栈
 左中右
 先放入最左 弹出 放入右子节点最左
 */
public class 非递归中序遍历二叉树 {

	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		List<Integer> res = new ArrayList<>();
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);
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
