package solving;


import java.util.ArrayList;
import java.util.List;

public class SameInorderTraversal {
	
	/*
	 Given two binary trees, determine whether they have the same inorder traversal
	 	  Tree 1        Tree 2
	 		5             3
	 	   / \           / \
	 	  3	  7         1   6
	 	 /   /             / \
	 	1   6             5   7
	 [1,3,5,6,7]       [1,3,5,6,7]
	 */
	
	public static void main(String[] args) {
		
		TreeNode tree1 = new TreeNode(5);
		tree1.left = new TreeNode(3);
		tree1.left.left = new TreeNode(1);
		tree1.right = new TreeNode(7);
		tree1.right.left = new TreeNode(6);
		
		TreeNode tree2 = new TreeNode(3);
		tree2.left = new TreeNode(1);
		tree2.right = new TreeNode(6);
		tree2.right.left = new TreeNode(5);
		tree2.right.right = new TreeNode(7);
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
	  /*inorder(tree1, list1);
		inorder(tree2, list2);
		
		System.out.println(list1.equals(list2));
		System.out.println(list1);
		System.out.println(list2);*/
		
		inorder(tree1, list1);
		System.out.println(inorderCheck(tree2, list1) && list1.isEmpty());
	}
	
	//1st way
	private static void inorder(TreeNode root, List<Integer> list) {
		
		if(root == null) return;
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
		
	}
	
	//Check while going through tree
	private static boolean inorderCheck(TreeNode root, List<Integer> list) {
		
		if(root == null) return true;
		if(!inorderCheck(root.left, list)) {
			return false;	
		}
		
		if(list.isEmpty() || list.get(0) != root.val) {
			return false;
		}
		
		list.remove(0);
		
		return inorderCheck(root.right, list);
	}
	
	
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		
		TreeNode(int val){
			this.val = val;
		}
	}
}

/*
 * Time Complexity: O(n + m)
 * Space Complexity: O(n+ m)
 */
