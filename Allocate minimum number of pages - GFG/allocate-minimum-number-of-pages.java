//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    private static boolean possibleToPlace(int[] arr, int k, int cap){
		int student = 1;
		int currPagesCount = 0;
		for(int i=0;i<arr.length;i++){
			if(currPagesCount + arr[i] <= cap){
				currPagesCount += arr[i];
			}
			else{
				student++;
				currPagesCount = arr[i];
			}
		}
		return (student <= k);
	}
    //Function to find minimum number of pages.
    public static int findPages(int[]arr,int N,int k)
    {
       
		if(arr.length < k) return -1;
		int start = arr[0];
		int end = arr[0];
		for(int i=1;i<arr.length;i++){
			start = Math.max(start,arr[i]);
			end+= arr[i];
		}
		int potentialAns = -1;
		while(start <= end){
			int mid = (start + end)/2;
			if(possibleToPlace(arr,k,mid) == true){
				potentialAns = mid;
				end = mid - 1;
			}
			else start = mid+1;
		}
		return potentialAns;
    }
};