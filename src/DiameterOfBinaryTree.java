/*
 543. Diameter of Binary Tree
	Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

	Example:
		Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
	Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

	Note: The length of path between two nodes is represented by the number of edges between them.
*/

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class diaPair {

		int d = 0;
		int ht = -1;
	}

	public static int diameterOfBinaryTree(TreeNode root) {
		diaPair ans = diameter2(root);
		return ans.d;
	}

	public static diaPair diameter2(TreeNode node) {

		if (node == null) {
			return (new DiameterOfBinaryTree()).new diaPair();
		}

		diaPair lpair = diameter2(node.left);
		diaPair rpair = diameter2(node.right);

		diaPair spair = (new DiameterOfBinaryTree()).new diaPair();
		spair.ht = Math.max(lpair.ht, rpair.ht) + 1;

		int self = lpair.ht + rpair.ht + 2;

		spair.d = Math.max(self, Math.max(lpair.d, rpair.d));

		return spair;

	}

}
