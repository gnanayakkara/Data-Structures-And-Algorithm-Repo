package sortings;

public class InsertionSort {
	
	public static void main(String[] args) {
		
		int arr[] = { 12, 11, 13, 5, 6 };
		arr = insertionSort(arr);

		for (int i : arr) {
			System.out.print(i + " ");
		}
		
	}

	static int[] insertionSort(int[] arr) {
		
		int moves = 0;

		for (int i = 1; i < arr.length; i++) {
			
			int value = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > value) {
				moves++;
				arr[j + 1] = arr[j];
				j--;
			}
			
			arr[j+1] = value;
		}
		System.out.println("Total moves : " + moves);
		return arr;
	}
}


/*
Time Complexity: O(n^2)
Auxiliary Space: O(1)
Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order.
And it takes minimum time (Order of n) when elements are already sorted.
Algorithmic Paradigm: Incremental Approach
Sorting In Place: Yes
Stable: Yes
Online: Yes
Uses: Insertion sort is used when number of elements is small.
It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.
*/