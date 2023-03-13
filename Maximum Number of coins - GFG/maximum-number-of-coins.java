//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>(N);
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(str[i]));
			}
			Solution obj = new Solution();
			System.out.println(obj.maxCoins(N, arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int maxCoins(int N, ArrayList<Integer> arr) {
		//Write your code here
		
		// extends nums array with start as 1 and end as 1. 
		int[] nums = new int[arr.size()+2];
		nums[0] = 1;
		nums[nums.length-1] = 1;
		int idx = 1;
		for(int el : arr) nums[idx++] = el;
		
		// Initialize dp arrays, 1 based indexing
		
		int dp[][] = new int[nums.length][nums.length]; // dp[i][j] -> stands for max coins at i steps,
		
		for(int i=1;i<nums.length-1;i++){
		    for(int j=i;j>=1;j--){
		        // iterate through window i and j
		        for(int k=j;k<=i;k++){
		            dp[j][i] = Math.max(nums[j-1]*nums[k]*nums[i+1]+ dp[j][k-1]+dp[k+1][i],
		            dp[j][i]);
		        }
		    }
		}
		return dp[1][nums.length-2];
	}
}