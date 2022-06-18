package tree.遍历;

import dp.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 后序遍历，也是那一条路径。只是左边节点弹出，父节点要继续压栈。
 右边节点弹出，父节点出栈
 需要一个prev节点来跟踪
 */
public class S145二叉树的后序遍历 {

	/*
		public List<Integer> postorderTraversal(TreeNode root) {
	        List<Integer> res = new ArrayList<>();
	        postOrder(res, root);
	        return res;
	    }

	    public void postOrder(List<Integer> res, TreeNode root) {
	        if (root == null) {
	            return;
	        }
	        postOrder(res, root.left);
	        postOrder(res, root.right);
	        res.add(root.val);
	    }
	 */

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode p = root, prev = null;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			if (p.right == null || p.right == prev) {
				res.add(p.val);
				prev = p;
				p = null;
			} else {
				stack.push(p);
				p = p.right;
			}
		}
		return res;
	}

}
