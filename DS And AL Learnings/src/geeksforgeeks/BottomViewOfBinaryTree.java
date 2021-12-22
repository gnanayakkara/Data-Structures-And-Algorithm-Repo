package geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/*
 * 3 Nov 2021
 */

/**
 * https://www.geeksforgeeks.org/bottom-view-binary-tree/
 */
public class BottomViewOfBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        
        bottomView(root);
	}
	
	static void bottomView(Node node) {
		
		if (node == null) return;
		
		TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		
		while(!q.isEmpty()) {
			
			Node temp = q.remove();
			int hd = temp.height;
			
			m.put(hd, temp.value);
			
			if(temp.left != null) {
				temp.left.height = hd -1 ;
				q.add(temp.left);
			}
			
			if(temp.right != null) {
				temp.right.height = hd + 1;
				q.add(temp.right);
			}
		}
		System.out.println(m.values());
	}
	
	static class Node{
		Node left;
		Node right;
		int value;
		int height;
		
		public Node(int value) {
			this.value = value;
		}
	}
}
