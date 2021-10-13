package sortings;

public class MergeSort {

	static int moves = 0;
	public static void main(String[] args) {

		int array[] = new int[] { 9, 2, 6, 4, 3, 5, 1 };

		sortArray(array);
		System.out.println("Total moves : " + moves);

		for (int a : array) {
			System.out.print(a + " ");
		}
	}

	public static void sortArray(int array[]) {
		mergeSort(array, new int[array.length], 0, array.length - 1);
	}

	public static void mergeSort(int[] array, int[] tempArray, int leftStart, int rightEnd) {

		if (leftStart >= rightEnd) {
			return;
		}

		int middle = (leftStart + rightEnd) / 2;

		mergeSort(array, tempArray, leftStart, middle);
		mergeSort(array, tempArray, middle + 1, rightEnd);
		mergeHalves(array, tempArray, leftStart, rightEnd);
		moves++;
	}

	private static void mergeHalves(int[] array, int[] tempArray, int leftStart, int rightEnd) {
		
		for (int a : array) {
			System.out.print(a + " ");
		}
		System.out.println();
		int leftEnd = (rightEnd + leftStart) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while(left <= leftEnd && right <= rightEnd) {
			
			if(array[left] <= array[right]) {
				tempArray[index] = array[left];
				left++;
			}else {
				tempArray[index] = array[right];
				right++;
			}
			index++;
		}
		
		System.arraycopy(array, left, tempArray, index, leftEnd - left + 1);
		System.arraycopy(array, right, tempArray, index, rightEnd - right + 1);
		System.arraycopy(tempArray, leftStart, array, leftStart, size);
	}

}


/**
 Time Complexity: 
				O(nlogn)
 * https://youtu.be/KF2j-9iSf4Q
 * https://youtu.be/mB5HXBb_HY8
 */
