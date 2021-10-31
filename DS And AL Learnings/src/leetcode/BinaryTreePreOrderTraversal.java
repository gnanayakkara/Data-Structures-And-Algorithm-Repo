package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 31 Oct 2021
 */

/*
 * https://en.wikipedia.org/wiki/Tree_traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/submissions/
 */

public class BinaryTreePreOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode("F");
		root.left = new TreeNode("B");
		root.left.left = new TreeNode("A");
		root.left.right = new TreeNode("D");
		root.left.right.left = new TreeNode("C");
		root.left.right.right = new TreeNode("E");
		
		root.right = new TreeNode("G");
		root.right.right = new TreeNode("I");
		root.right.right.left = new TreeNode("H");
		
		List<String> list = preorderTraversal(root);
		
		for(String s : list) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
	static List<String> preorderTraversal(TreeNode root) {
        
        List<String> list = new ArrayList(); 
        preorder(root,list);
        return list;
    }
	
	static void preorder(TreeNode root, List<String> list){
        
        if(root == null){
            return;
        }
        
        list.add(root.val);
        
        if(root.left != null){
            preorder(root.left,list);
        }
        if(root.right != null){
            preorder(root.right,list);
        }
    }
	
	static class TreeNode{
		
		TreeNode left;
		TreeNode right;
		String val;
		
		public TreeNode(String val) {
			this.val = val;
		}
	}
}
