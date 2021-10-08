package sortings;

public class QuickSort {
	
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
		quickSort(array, 0, array.length-1);
	}
	
	public static void quickSort(int array[],int left, int right) {
		
		if(left >= right) {
			return;
		}
		
		//Middle one take as pivot
		int pivot = array[(left+right)/2];
		int index = partition(array, left, right, pivot);
		
		quickSort(array, left, index-1);
		quickSort(array, index, right);
	}
	
	public static int partition(int array[],int left, int right, int pivot) {
		
		while(left <= right) {
			
			while(array[left] < pivot) {
				left++;
			}
			
			while(array[right] > pivot) {
				right--;
			}
			
			if(left <= right) {
				swap(array ,left,right);
				left++;
				right--;
			}
		}
		
		return left;
	}
	
	/**
	 * Swap left and right values
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void swap(int array[],int left,int right) {
		
		int temp = array[left];
		
		array[left] = array[right];
		array[right] = temp;
		
		//to count moves
		moves++;
	}
	
}


/*
 * https://www.youtube.com/watch?v=7h1s2SojIRw&ab_channel=AbdulBari
 * https://www.youtube.com/watch?v=SLauY6PpjW4&t=7s&ab_channel=HackerRank
 */
