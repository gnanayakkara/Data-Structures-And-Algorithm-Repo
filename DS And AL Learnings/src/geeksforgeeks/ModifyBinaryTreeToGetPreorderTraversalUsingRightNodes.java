package geeksforgeeks;

import java.util.Stack;

/*
 * 30 Oct 2021
 */

/*
 * https://www.geeksforgeeks.org/modify-binary-tree-get-preorder-traversal-using-right-pointers/
 * 
Input :   10
         /  \
        8    2
       / \    
      3   5  
Output :    10
		     \
		      8
		       \ 
		        3
		         \
		          5
		           \
		            2
Explanation : The preorder traversal
of given binary tree is 10 8 3 5 2
*/

public class ModifyBinaryTreeToGetPreorderTraversalUsingRightNodes {
	
	public static void main(String[] args) {
		
		Node root = new Node(10);
	    root.left = new Node(8);
	    root.right = new Node(2);
	    root.left.left = new Node(3);
	    root.left.right = new Node(5);
	    
	    modifyTree(root);
	    printpre(root);
	}
	
	// printing using right pointer only
	static void printpre(Node root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.right;
		}
	}
	
	static void modifyTree(Node root) {
		
		if(root == null) return;
		
		Stack<Node> nodeStack = new Stack<>();
		nodeStack.push(root);
		
		Node pre = null;
		
		while(!nodeStack.isEmpty()) {
			
			Node node = nodeStack.peek();
			nodeStack.pop();
			
			// Push right and left children of
	        // the popped node to stack
			if(node.right != null) {
				nodeStack.push(node.right);
			}
			
			if(node.left != null) {
				nodeStack.push(node.left);
			}
			
			if(pre != null) {
				pre.right = node;
			}
			
			// set previous node as current node
			pre = node;
		}
	}
	
	static class Node{
		
		Node left;
		Node right;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
}
