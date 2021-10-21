package customize_collection;

import java.util.Arrays;


public class Heap {

	private static int capacity = 10;
	private static int size = 0;
	
	static int[] items = new int[capacity];
	
	public static void main(String[] args) {
		items = new int[] { 9, 2, 6, 4, 3, 5, 1 };
		add(9);
		add(2);
		add(6);
		add(4);
		add(3);
		add(5);
		add(1);
		
		for(;size > 0;) {
			System.out.print(poll() + " ");
		}
	}
	
	private static int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}
	
	private static int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}
	
	private static int getParentIndex(int childIndex) {
		return (childIndex -1 ) / 2;
	}
	
	private static boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	
	private static boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	
	private static boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}
	
	private static int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	
	private static int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}
	
	private static int parent(int index) {
		return items[getParentIndex(index)];
	}
	
	private static void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	private static void ensureExtraCapacity() {
		if(size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	private static int peek() {
		if(size == 0) throw new IllegalStateException();
		return items[0];
	}
	
	private static int poll() {
		if(size == 0) throw new IllegalStateException();
		int item = items[0]; //Get the top of Heap
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}
	 
	private static void add(int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	private static void heapifyUp() {
		int index = size -1;
		while( hasParent(index) &&  parent(index) > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	private static void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if(items[index] < items[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}
			index = smallerChildIndex;
		}
		
	}
}


/*
 * https://youtu.be/t0Cq6tVNRBA
 */