package geeksforgeeks;

/*
 * 31 Oct 2021
 */

/*
 * https://www.geeksforgeeks.org/find-the-element-that-appears-once-in-a-sorted-array/
 */

public class FindTheElementThatAppearsOnceInSortedArray {

	public static void main(String[] args) {
		int arr[] = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8};
		search(arr, 0, arr.length -1);
	}
	
	static void search(int arr[], int low, int high ) {
		
		if(low > high) {
			return;
		}
		
		if(low == high) {
			System.out.println("The required element is " + arr[low]);
			return;
		}
		
		int mid = (low + high) / 2;
		
		// If mid is even and element next to mid is
        // same as mid, then output element lies on
        // right side, else on left side
		if(mid % 2 == 0) {
			if(arr[mid] == arr[mid + 1]) {
				search(arr, mid + 2, high);
			}else {
				search(arr, low, mid);
			}
		}
		
		//If mid is odd and element below to mid is same as mid, 
		//then output element lies on right side,else on left side
		if(mid % 2 == 1) {
			if(arr[mid]  == arr[mid - 1]) {
				search(arr, mid + 1, high);
			}else {
				search(arr, low, mid -1);
			}
		}
		
	}
}
