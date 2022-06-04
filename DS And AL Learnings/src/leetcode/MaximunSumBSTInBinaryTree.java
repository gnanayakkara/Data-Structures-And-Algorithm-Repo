package leetcode;

/*
 * 28 May 2022
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
 */

public class MaximunSumBSTInBinaryTree {
	
	static int maxSum = 0;
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(4);
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(4);
		
		node.right = new TreeNode(3);
		node.right.left = new TreeNode(2);
		node.right.right = new TreeNode(5);
		node.right.right.left = new TreeNode(4);
		node.right.right.right = new TreeNode(6);
		
		maxSumBST(node) ;
		
		System.out.println(maxSum);
	}
	
	 public static int[] maxSumBST(TreeNode root) {
		 
		 if(root == null) {
			 return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; // {min, max, sum}
		 }
		 
		 int[] leftTree = maxSumBST(root.left);
		 int[] rightTree = maxSumBST(root.right);
		 
		 if(leftTree == null || rightTree == null 
				 || root.val <= leftTree[1] | root.val >= rightTree[0]) {
			 return null;
		 }
		 
		 int sum = root.val + leftTree[2] + rightTree[2];
		 maxSum = Math.max(maxSum, sum);
		 
		 int max = Math.max(root.val, rightTree[1]);
		 int min = Math.min(root.val, leftTree[0]);
		 
		 return new int[] {min,max,sum};
	 }

}

class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}