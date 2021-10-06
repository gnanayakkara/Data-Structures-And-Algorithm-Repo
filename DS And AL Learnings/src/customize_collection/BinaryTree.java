package customize_collection;


/*
 * https://www.youtube.com/watch?v=oSWTXtMglKE&ab_channel=HackerRank
 * 
 */

public class BinaryTree {
	
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode();
		treeNode.addNode(10);
		treeNode.addNode(20);
		treeNode.addNode(13);
		treeNode.addNode(5);
		treeNode.addNode(8);
		
		treeNode.printNodes();
		
		System.out.println("Sum : " + treeNode.getSum(treeNode.node));
	}
}

class TreeNode{
	
	Node node = null;
	
	public void addNode(int value) {
		if(node == null) {
			node = new Node(value);
		}else {
			node.insert(value);
		}
	}
	
	public void printNodes() {
		node.printInOrder();
	}
	
	/**
	 * O(n)
	 * https://www.youtube.com/watch?v=1-l_UOFi1Xw&ab_channel=CSDojo
	 * @param node
	 * @return
	 */
	public int getSum(Node node) {
		
		if(node == null) {
			return 0;
		}
		
		return node.data + getSum(node.left) + getSum(node.right);
	}
	
	static class Node{
		Node left,right;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
		
		public void insert(int value) {
			
			if(value <= data) {
				//left side
				if(left == null) {
					left = new Node(value);
				}else {
					left.insert(value);
				}
			}else {
				//right side
				if(right == null) {
					right = new Node(value);
				}else {
					right.insert(value);
				}
			}
		}
		
		public boolean contains(int value) {
			
			if(value == data) {
				return true;
			}else if( value < data) {
				if(left == null) {
					return false;
				}else {
					return left.contains(value);
				}
			}else {
				if(right == null) {
					return false;
				}else {
					return right.contains(value);
				}
			}
		}
		
		//In order traversing
		public void printInOrder() {
			
			if(left != null) {
				left.printInOrder();
			}
			
			System.out.println(data);
			
			if(right != null) {
				right.printInOrder();
			}
		}
		
	}
	
}
