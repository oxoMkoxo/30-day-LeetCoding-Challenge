
/*
 * 1008. Construct Binary Search Tree from Preorder Traversal
 * 
 * 	Return the root node of a binary search tree that matches the given preorder traversal.
 * 	(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left 
 * 	has a value < node.val, and any descendant of node.right has a value > node.val.  
 * 	Also recall that a preorder traversal displays the value of the node first, then traverses node.left, 
 * 	then traverses node.right.)
 * 
 * 	It's guaranteed that for the given test cases there is always possible to find a binary search tree 
 * 	with the given requirements.
 * 	Example 1:
 * 		Input: [8,5,1,7,10,12]
 * 		Output: [8,5,10,1,7,null,12]
 *  
 * 
 */
import java.util.Scanner;

import cruxday21_24july_BT.BinaryTree.Node;

public class ConstructBinarySearchTreeFromPreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int sizeOfArray = scn.nextInt();
		int[] arr = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			arr[i] = scn.nextInt();
		}
		TreeNode root = bstFromPreorder(arr);
		display(root);
		scn.close();
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode bstFromPreorder(int[] preorder) {
		ConstructBinarySearchTreeFromPreorderTraversal x = new ConstructBinarySearchTreeFromPreorderTraversal();
		return construct(preorder, x.new Index(), 0, preorder.length - 1, preorder.length);
	}

	public class Index {
		int index = 0;
	}

	public static TreeNode construct(int pre[], Index preIndex, int low, int high, int size) {
		if (preIndex.index >= size || low > high) {
			return null;
		}

		TreeNode root = (new ConstructBinarySearchTreeFromPreorderTraversal()).new TreeNode(pre[preIndex.index]);
		preIndex.index = preIndex.index + 1;

		if (low == high) {
			return root;
		}

		int i;
		for (i = low; i <= high; ++i) {
			if (pre[i] > root.val) {
				break;
			}
		}

		root.left = construct(pre, preIndex, preIndex.index, i - 1, size);
		root.right = construct(pre, preIndex, i, high, size);

		return root;
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

}
