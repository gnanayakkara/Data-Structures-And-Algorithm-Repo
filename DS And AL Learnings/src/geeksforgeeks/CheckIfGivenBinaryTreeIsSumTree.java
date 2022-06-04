package geeksforgeeks;

/*
 * 4 Jun 2022
 * https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 */

public class CheckIfGivenBinaryTreeIsSumTree {
	
	public static void main(String[] args) {
		
		Node node = new Node(26);
        node.left=new Node(10);
        node.right=new Node(3);
        node.left.left=new Node(4);
        node.left.right=new Node(6);
        node.right.right=new Node(3);
        
		if (isBinarySumTree2(node) != 0) {
			System.out.println("The given tree is a SumTree");
		} else {
			System.out.println("The given tree is not a SumTree");
		}
	}
	
	
	private static int sum(Node node) {
		
		if(node == null) {
			return 0;
		}
		return sum(node.left) + node.data + sum(node.right);
	}
	
	private static int isBinarySumTree(Node node) {
		
		int leftVal,rightVal;
		
		if(node == null || (node.left == null && node.right == null)) {
			return 1;
		}
		
		leftVal = sum(node.left);
		rightVal = sum(node.right);
		
		if((node.data == leftVal + rightVal) && isBinarySumTree(node.left) != 0 && isBinarySumTree(node.right) != 0) {
			return 1;
		}
		
		return 0;
		
	}
	
	private static int isBinarySumTree2(Node node) {
		
		int leftVal,rightVal;
		
		if(node == null) {
			return 0;
		}
		
		leftVal = isBinarySumTree2(node.left);
		rightVal = isBinarySumTree2(node.right);
		
		if(rightVal == 0 && leftVal == 0) {
			return node.data;
		}else if (rightVal + leftVal == node.data) {
			return leftVal+rightVal+node.data;
		}
		
		return 0;
	}
	
	static class Node{
		
		int data;
		Node left,right;
		
		public Node(int data) {
			this.data = data;
		}
	}
}


