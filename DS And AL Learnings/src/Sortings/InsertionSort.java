package Sortings;

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
