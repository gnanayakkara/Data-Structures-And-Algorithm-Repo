package geeksforgeeks;

/*
 * 30 Oct 2021
 */

/*
 * https://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
 */

public class RemoveDuplicatesFromSortedLinkedList {

	public static void main(String[] args) {
		
		LinkedList llist = new LinkedList();
        llist.push(20);
        llist.push(13);
        llist.push(13);
        llist.push(11);
        llist.push(11);
        llist.push(11);
         
        System.out.println("List before removal of duplicates");
        llist.printList();
         
        llist.removeDuplicates();
         
        System.out.println("List after removal of elements");
        llist.printList();
	}
	
	static class LinkedList{
		
		Node head;
		
		class Node{
			Node next;
			int data;
			public Node(int data) {
				this.data = data;
			}
		}
		
		private void push(int data) {
			//Create a node and assign value
			Node newNode = new Node(data);
			//Make new 
			newNode.next = head;
			head = newNode;
		}
		
		private void printList() {
			
			Node temp = head;
			
			while(temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			
			System.out.println();
		}
		
		private void removeDuplicates() {
			
			Node curr = head;
			
			while(curr != null) {
				
				Node temp = curr;
				
				/*Compare current node with the next node and 
				 * keep on deleting them until it matches the current
	            node data */
				while(temp != null && temp.data == curr.data) {
					temp = temp.next;
				}
				
				/*Set current node next to the next different element denoted by temp*/
				curr.next = temp;
				curr = curr.next;
			}
		}
	}
}

/*
 * Time Complexity: O(n)
 */