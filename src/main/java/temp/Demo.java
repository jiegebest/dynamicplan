package temp;

public class Demo {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);

		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n2.right = n5;

		n3.left = n7;
		n3.right = n8;

		n4.left = n9;
		n4.right = n10;

		Result res = getCommonFatherNode(n1, n7, n8);
		System.out.println(res.target.val);
	}

	public static Result getCommonFatherNode(TreeNode root, TreeNode t1, TreeNode t2) {
		Result res = postOrder(root, t1, t2);
		return res;
	}

	public static Result postOrder(TreeNode node, TreeNode t1, TreeNode t2) {
		if (node == null) {
			return new Result(0, null);
		}

		int cnt = (node == t1 || node == t2) ? 1 : 0;
		Result left = postOrder(node.left, t1, t2);
		if (left.cnt == 2) {
			return left;
		}
		Result right = postOrder(node.right, t1, t2);
		if (right.cnt == 2) {
			return right;
		}

		cnt += left.cnt + right.cnt;
		return new Result(cnt, node);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode() {

	}
	public TreeNode(int val) {
		this.val = val;
	}
}

class Result {
	public int cnt;
	public TreeNode target;

	public Result() {

	}

	public Result(int cnt, TreeNode target) {
		this.cnt = cnt;
		this.target = target;
	}
}
