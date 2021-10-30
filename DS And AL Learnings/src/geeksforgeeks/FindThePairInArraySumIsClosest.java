package geeksforgeeks;

/*
 * 30 Oct 2021
 */

/*
 * https://www.geeksforgeeks.org/given-sorted-array-number-x-find-pair-array-whose-sum-closest-x/
 */

public class FindThePairInArraySumIsClosest {

		public static void main(String[] args) {
			 int arr[] =  {10, 22, 28, 29, 30, 40}, x = 54;
	         int n = arr.length;
	         printClosest(arr, n, x);
		}
		
		static void printClosest(int arr[], int n, int x){
			
			int res_l = 0; int res_r = 0; //To store indexes of result pair
			
			//Initialize left and right indexes and difference between pair sum and x
			int l = 0, r = n-1, diff = Integer.MAX_VALUE;
			
			while(l < r) {
				if(Math.abs(arr[l] + arr[r] - x) < diff) {
					res_l = l;
					res_r = r;
					diff = Math.abs(arr[l] + arr[r] - x);
				}
				
				//Array is sorted and if value is greater than x, we should consider less value
				if(arr[l] + arr[r] > x) {
					r--;
				}else {
					l++; //if value is less than x, we should go for higher value
				}
			}
			
			System.out.println(" The closest pair is "+arr[res_l]+" and "+ arr[res_r]);
	    }
}


/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */