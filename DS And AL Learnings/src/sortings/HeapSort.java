package sortings;

public class HeapSort {

	public static void main(String[] args) {

		int arr[] = { 9, 2, 6, 4, 3, 5, 1 };
		sortArray(arr);

		for (int i : arr) {
			System.out.print(i + " ");
		}

	}
	
	static void sortArray(int array[]) {
		heapSort(array);
	}
	
	static void heapSort(int array[]) {
		
		//Building Heap
		/*
		 *      0
		 *   0     0    //because it should start from 2nd layer
		 * 0   0 0	 0
		 */
		for(int i = array.length/2 - 1; i >= 0; i--) {
			heapify(array,array.length, i);
		}
		
		// One by one extract an element from heap
		for(int i = array.length -1; i > 0; i--) {
			swap(array, 0, i); //swap eligible last element to first
			// call max heapify on the reduced heap
			heapify(array, i, 0); //again rearrange heap
		}
		
	}

	static void heapify(int[] array,int size, int index) {
		
		int largest = index;
		int left = getLeftChildIndex(index);
		int right = getRightChildIndex(index);
		
		if(left < size && array[left] > array[largest]){
			largest = left;
		}
		
		if(right < size && array[right] > array[largest]) {
			largest = right;
		}
		
		if(largest != index) {
			swap(array, index, largest);
			heapify(array, size, largest);
		}
	}

	static int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

 	static int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}
	
	static void swap(int[] array, int indexOne, int indexTwo) {
		int temp = array[indexOne];
		array[indexOne] = array[indexTwo];
		array[indexTwo] = temp;
	}

}

/*
 * https://youtu.be/HqPJF2L5h9U https://youtu.be/MtQL_ll5KhQ
 * https://www.geeksforgeeks.org/heap-sort/
 * https://youtu.be/Q_eia3jC9Ts
 */