package tree.遍历;

import dp.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class S94二叉树的中序遍历 {

	/*
		public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> res = new ArrayList<>();
	        inorder(res, root);
	        return res;
	    }

	    public void inorder(List<Integer> res, TreeNode root) {
	        if (root == null) {
	            return;
	        }
	        inorder(res, root.left);
	        res.add(root.val);
	        inorder(res, root.right);
	    }
	 */

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			res.add(p.val);
			p = p.right;
		}
		return res;
	}

}
