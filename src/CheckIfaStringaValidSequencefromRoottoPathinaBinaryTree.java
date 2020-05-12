/*
 * 1430. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 * 
 * Given a binary tree where each path going from the root to any leaf
 * form a valid sequence, check if a given string is a valid sequence in such
 * binary tree.
 * 
 * we get the given string from the concatenation of an array of integers arr and the
 * concatenation of all values of the nodes along a path result ina 
 * sequence in the given binary tree.
 * 
 * 
 */



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CheckIfaStringaValidSequencefromRoottoPathinaBinaryTree {
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

	public CheckIfaStringaValidSequencefromRoottoPathinaBinaryTree(String s) {
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

	public boolean isValidSequence(TreeNode root, int[] arr) {
		if (arr.length == 0) {
			return true;
		}
		return recur(root, 0, arr);
	}

	public boolean recur(TreeNode node, int indx, int[] arr) {
		if (node.left == null && node.right == null && indx == arr.length - 1 && arr[indx] == node.val) {
			return true;
		}
		if (indx >= arr.length) {
			return false;
		}
		if (arr[indx] != node.val) {
			return false;
		}
		boolean left = false;
		boolean right = false;

		if (node.left != null) {
			left = recur(node.left, indx + 1, arr);
		}
		if (node.right != null) {
			right = recur(node.right, indx + 1, arr);
		}
		return left || right;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String tree = scn.next();
		String s = scn.next();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\],]");
		int[] arr = new int[st.countTokens()];
		int i = 0;
		while (st.hasMoreElements()) {
			arr[i] = Integer.parseInt(st.nextElement().toString());
			i++;
		}
		CheckIfaStringaValidSequencefromRoottoPathinaBinaryTree obj = new CheckIfaStringaValidSequencefromRoottoPathinaBinaryTree(
				tree);
		System.out.println(obj.isValidSequence(obj.root, arr));
		scn.close();
	}

}
