package sortings;

public class BubbleSort {
	
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
		bubbleSort(array);
	}
	
	public static void bubbleSort(int[] array) {
		
		boolean isSorted = false;
		int lastUnsorted = array.length-1;
		
		while(!isSorted) {
			isSorted = true;
			for(int i = 0; i < lastUnsorted; i++) {
				if(array[i] > array[i+1]) {
					swap(array, i, i+1);
					isSorted = false;
					moves++;
				}
			}
			
			lastUnsorted--;//Last one is the biggest one
			
			for (int a : array) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
	
	public static void swap(int[] array,int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
}


/**
 * https://youtu.be/6Gv8vg0kcHc
 */
