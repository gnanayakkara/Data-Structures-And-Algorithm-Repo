package customize_collection;

import customize_collection.DoublyLinkedList.Node;

public class CustomizeDoublyLinkedList {
	
	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList();
		doublyLinkedList.add(10);
		doublyLinkedList.add(5);
		Node<Integer> node = doublyLinkedList.add(15);
		
		System.out.println(node.previousNode.previousNode.data);
		System.out.println(node.previousNode.data);
		System.out.println(node.previousNode.nextNode.data);
		
		System.out.println("Size : " + doublyLinkedList.size());
	}
}

class DoublyLinkedList<E>{
	
	static class Node<E>{
		
		Node<E> previousNode;
		Node<E> nextNode;
		
		E data;
		
		public Node(E data) {
			this.data = data;
		}
	}
	
	Node<E> headNode;
	Node<E> lastNode;
	
	public Node<E> add(E data) {
		if(headNode == null) {
			headNode = new Node<E>(data);
			lastNode = headNode;
		}else {
			Node<E>  currentNode = new Node<E>(data);
			currentNode.previousNode = lastNode;
			lastNode.nextNode = currentNode;
			lastNode = currentNode;
		}
		return lastNode;
	}
	
	public int size() {
		
		int count = 0;
		Node<E> current = null;
		
		if(headNode != null) {
			count++;
			current = headNode;
		}
		
		while(current != null && current.nextNode != null) {
			count++;
			current = current.nextNode;
		}
		return count;
	}
	
}

