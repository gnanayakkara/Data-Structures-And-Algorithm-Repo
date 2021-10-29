package hackerrank;

/*
 * 29 Oct 2021
 */

public class HeightOfBinaryTree {

	public static void main(String[] args) {
		
		TreeNode root = null;
		root = insertNode(root, 3);
		insertNode(root, 2);
		insertNode(root, 1);
		insertNode(root, 5);
		insertNode(root, 4);
		insertNode(root, 6);
		insertNode(root, 7);
		//insertNode(root, 8);
		
		System.out.println(treeHeight(root));
	}
	
	static int treeHeight(TreeNode root) {
		
		int left = 0;
		int right = 0;
		
		if(root.left != null) {
			left = 1 + treeHeight(root.left);
		}
		
		if(root.right != null) {
			right = 1 + treeHeight(root.right);
		}
		
		return Math.max(left, right);
	}

	static TreeNode insertNode(TreeNode root, int data) {

		if (root == null) {
			return new TreeNode(data);
		} else {
			if (data <= root.data) {
				root.left = insertNode(root.left, data);
			} else {
				root.right = insertNode(root.right, data);
			}
			return root;
		}
	}

	static class TreeNode {

		TreeNode left;
		TreeNode right;
		int data;

		public TreeNode(int data) {
			this.data = data;
		}
	}
}

/*
 * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
 */