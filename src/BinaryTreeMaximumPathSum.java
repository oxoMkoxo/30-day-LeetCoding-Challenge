import java.util.*;

public class BinaryTreeMaximumPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	TreeNode root;

	public BinaryTreeMaximumPathSum(String s) {
		// TODO Auto-generated constructor stub
		s = s.substring(1, s.length() - 1);
		String[] element = s.split("[,]");
		root = constructBT(element);
	}

	public TreeNode constructBT(String[] s) {
		int indx = 0;
		TreeNode head = new TreeNode(Integer.parseInt(s[indx++]), null, null);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(head);
		while (!q.isEmpty() && indx < s.length) {
			TreeNode temp = q.poll();
			if (!s[indx].equals("null")) {
				TreeNode leftNode = new TreeNode(Integer.parseInt(s[indx++]), null, null);
				temp.left = leftNode;
				q.add(leftNode);
			} else {
				indx++;
			}
			if (indx < s.length && (!s[indx].equals("null"))) {
				TreeNode rightNode = new TreeNode(Integer.parseInt(s[indx++]), null, null);
				temp.right = rightNode;
				q.add(rightNode);
			} else {
				indx++;
			}

		}
		return head;
	}

	public void display() {
		display(root);
	}

	private static void display(TreeNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		String str = "";
		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.val + "";

		}
		str += "->" + node.val + "->";
		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.val;
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public int maxPathSum(TreeNode root) {
		int[] maxsum = new int[1];
		maxsum[0] = Integer.MIN_VALUE;
		maxSubtreeSum(root, maxsum);
		return maxsum[0];
	}

	private int maxSubtreeSum(TreeNode node, int[] maxsum) {

		if (node == null) {
			return 0;
		}

		int ls = Math.max(maxSubtreeSum(node.left, maxsum), 0);
		int rs = Math.max(maxSubtreeSum(node.right, maxsum), 0);

		int ts = ls + rs + node.val;

		if (ts > maxsum[0]) {
			maxsum[0] = ts;
		}

		return Math.max(ls, rs) + node.val;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum(s);
		System.out.println(obj.maxPathSum(obj.root));
		scn.close();
	}

}
