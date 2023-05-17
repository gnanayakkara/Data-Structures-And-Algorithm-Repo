package Solving;

/*
 * 30 Oct 2021
 */

public class FindThePairWhichMatchToTarget {
	
	public static void main(String[] args) {
		
		int arr[] = {2,7,11,15};
		int n = arr.length;
		int x = 15;
		
		printMatchingPair(arr, n, x);
	}
	
	static void printMatchingPair(int arr[], int n, int x) {
		
		int l = 0, r = n-1;
		boolean isMatching = false;
		
		while(l < r) {
			
			if(arr[l] + arr[r] == x) {
				isMatching = true;
				break;
			}else if(arr[l] + arr[r] > x) {
				r--;
			}else {
				l++;
			}
		}
		
		if(isMatching) {
			System.out.println("Matching pair is : " + arr[l] +" and " + arr[r]);
		}else {
			System.out.println("No matching pair");
		}
	}
}
