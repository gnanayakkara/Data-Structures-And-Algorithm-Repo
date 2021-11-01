package geeksforgeeks;

import java.util.Arrays;

/*
 * 1 Nov 2021
 */

/**
 * https://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/
 */

public class FindUnionAndIntersectionOfTwoUnsortedArray_Method2 {

	public static void main(String[] args) {
		
		int arr1[] = { 7, 1, 5, 2, 3, 6 };
        int arr2[] = { 3, 8, 6, 20, 7 };
        
        printUnion(arr1, arr2, arr1.length - 1, arr2.length - 1);
        printIntersection(arr1, arr2, arr1.length -1, arr2.length -1);
	}
	
	static void printUnion(int arr1[], int arr2[], int m, int n) {
		
		//Make sure array is small
		if(m > n) {
			int temp[] = arr1;
			arr1 = arr2;
			arr2 = temp;
			
			m = arr1.length-1;
			n = arr2.length-1;
		}
		
		//Sort arr1
		Arrays.sort(arr1);
		//then print array one
		for(int i : arr1) {
			System.out.print(i + " ");
		}
		
		// Search every element of bigger array in smaller
        // array and print the element if found
		//This to print not available values in first array
		for(int i = 0; i <= n; i++) {
			if(binarySearch(arr1, 0, m, arr2[i]) == -1) {
				System.out.print(arr2[i] + " ");
			}
		}
		System.out.println();
	}
	
	static void printIntersection(int arr1[], int arr2[], int m, int n) {
		
		//Make sure array is small
		if(m > n) {
			int temp[] = arr1;
			arr1 = arr2;
			arr2 = temp;
			
			m = arr1.length-1;
			n = arr2.length-1;
		}
		
		//Sort arr1
		Arrays.sort(arr1);
		
		// Search every element of bigger array in smaller
        // array and print the element if not found
		//This to print not available values in first array
		for(int i = 0; i <= n; i++) {
			if(binarySearch(arr1, 0, m, arr2[i]) != -1) {
				System.out.print(arr2[i] + " ");
			}
		}
		System.out.println();
	}
	
	static int binarySearch(int arr[], int low, int high, int val) {
		
		if(low <= high) {
			
			int mid = (low + high) / 2;
			
			if(arr[mid] == val) {
				return mid;
			}else if(arr[mid] > val) {
				return binarySearch(arr, low, mid - 1, val);
			}else {
				return binarySearch(arr, mid + 1, high, val);
			}
		}else {
			return -1;
		}
	}
}
