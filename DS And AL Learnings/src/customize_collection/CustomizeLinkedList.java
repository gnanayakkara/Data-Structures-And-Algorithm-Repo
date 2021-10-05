package customize_collection;

public class CustomizeLinkedList {
	
	public static void main(String[] args) {
		LinkedList<Integer> lst = new LinkedList<Integer>();
		lst.add(10);
		lst.add(1);
		lst.add(2);
		lst.add(5);
		
		System.out.println(lst);
		
		
		LinkedList<String> stringLst = new LinkedList<String>();
		stringLst.add("A");
		stringLst.add("B");
		stringLst.add("C");
		stringLst.add("D");
		
		System.out.println(stringLst.get(0));
		
		System.out.println("Index Value : " + stringLst.get(0));
		
	}

}

class LinkedList<E>{
	
	Node<E> headNode;
	Node<E> lastNode;
	
	public Node<E> add(E value) {
		if(headNode == null) {
			headNode =  new Node<E>(value);
			lastNode = headNode;
		}else {
			lastNode.next =  new Node<E>(value);
			lastNode = lastNode.next;
		}
		
		return headNode;
	}
	
	
	public int size() {
		
		int count = 0;
		Node<E> current = null;
		
		if(headNode != null) {
			count++;
			current = headNode;
		}
		
		while(current != null && current.next != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	
	public E get(int index) {
		
		int count = 0;
		Node<E> node = headNode;
		
		while(count < index) {
			count++;
			if(node == null) {
				throw new ArrayIndexOutOfBoundsException();
			}
			node = node.next;
		}
		
		return node.data;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		Node<E> current = headNode;
		while(current != null) {
			stringBuilder.append(current.data +" ");
			current = current.next;
		}
		return stringBuilder.toString();
	}
	
}

class Node<E> {
	
	Node<E> next;
	E data;

	public Node(E data) {
		this.data = data;
	}
}
