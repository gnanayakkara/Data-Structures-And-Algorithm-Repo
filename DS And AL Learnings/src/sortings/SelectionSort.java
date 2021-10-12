package sortings;

public class SelectionSort {

	static int moves = 0;
	
	public static void main(String[] args) {
		
		int array[] = new int[] {9,2,6,4,3,5,1};
		
		sortArray(array);
		System.out.println("Total moves : " + moves);
		
		for(int a : array) {
			System.out.print(a + " ");
		}
	}
	
	public static void sortArray(int array[]) {
		selectionSort(array);
	}
	
	public static void selectionSort(int array[]) {
		
		for(int i = 0; i < array.length -1; i++) {
			
			int minIndex = i;
			
			for(int j = i+1; j < array.length; j++) {
				
				if(array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
			moves++;
		}
	}
}


/*
 * 
 * Time Complexity : 
 * 		O(n2) as there are two nested loops.
 *      The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
 * https://www.geeksforgeeks.org/selection-sort/
 */
