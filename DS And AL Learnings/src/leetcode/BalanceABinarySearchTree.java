package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 2 Nov 2021
 */

/**
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 */
public class BalanceABinarySearchTree {

	static List<TreeNode> sortedArr = new ArrayList<>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		
		root = balanceBST(root);
		
		System.out.println();
	}
	
	 static TreeNode balanceBST(TreeNode root) {
		inorderTraverse(root);
		return sortedArrayToBST(0, sortedArr.size() - 1);
	}
	
	static void inorderTraverse(TreeNode root) {
		
		if(root == null) {
			return;
		}
		
		inorderTraverse(root.left);
		sortedArr.add(root);
		inorderTraverse(root.right);
	}
	
	static TreeNode sortedArrayToBST(int start, int end) {
		
		if(start > end) return null;
		int mid = (start + end)/2;
		
		TreeNode root = sortedArr.get(mid);
		root.left = sortedArrayToBST(start, mid - 1);
		root.right = sortedArrayToBST(mid + 1, end);
		
		return root;
	}
	
	static class TreeNode {
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
}
