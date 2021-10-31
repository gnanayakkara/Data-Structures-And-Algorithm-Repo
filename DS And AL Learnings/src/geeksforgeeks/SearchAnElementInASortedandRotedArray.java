package geeksforgeeks;

/*
 * 31 Oct 2021
 */

/*
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */

public class SearchAnElementInASortedandRotedArray {

	public static void main(String[] args) {
		
		int arr[] = {3,4,5,6,1,2};
		int key = 1;
		
		int index = pivotedBinarySearch(arr, arr.length-1, key);
		
		System.out.println("Index is : " + index);
	}
	
	static int pivotedBinarySearch(int arr[], int n, int key) {
		
		int pivot = findPivot(arr, 0, n -1);
		
		//if we didnt find pivot we go for normal binary search
		if(pivot == -1) {
			return binarySearch(arr, 0, n, key);
		}
		
		//if we found pivot first check with pivot value
		if(arr[pivot] == key) {
			return pivot;
		}
		//3 < 4
		if(arr[0] <= key) {
			return binarySearch(arr, 0, pivot -1, key);
		}
		//6 > 1
		if(arr[pivot] > key) {
			return binarySearch(arr, pivot + 1, n, key);
		}
		
		
		return 0;
	}
	
	static int binarySearch(int arr[], int low,int high,int key) {
		
		if(low > high) return -1;
		
		int mid = (low + high)/2;
		
		if(key == arr[mid]) {
			return mid;
		}
		
		if(key > arr[mid]) {
			return binarySearch(arr, mid+1, high, key);
		}else {
			return binarySearch(arr, low, mid-1, key);
		}
	}

	/*
	 * [ 3,4,5,6,1,2] pivot is index 3. Value 6
	 */
	static int findPivot(int[] arr, int low, int high) {
		
		if(high < low) return -1;
		
		if(high == low) return low;
		
		int mid = (low + high)/2;
		
		if(mid < high && arr[mid] > arr[mid +1]) {
			return mid;//this is the pivot
		}else if(mid > low && arr[mid-1] > arr[mid]) {
			return mid - 1;
		}
		
		if(arr[low] >= arr[mid]) {
			return findPivot(arr, low, mid -1);
		}else {
			return findPivot(arr, mid+1, high);
		}
	}
}
