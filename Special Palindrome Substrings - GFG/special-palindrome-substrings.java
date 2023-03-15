//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    int ans = obj.specialPalindrome(s1,s2);
		    System.out.println(ans);
		    
		    
		    
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    public  static int specialPalindrome(String a, String b){
       //Code Here
       // Calculate the length of strings a and b
        int n1 = a.length(), n2 = b.length();
        // Initialize the answer to be the maximum integer value
        int ans = Integer.MAX_VALUE;
        // Iterate over all possible substrings of a that are of the same length as b
        for (int i = 0; i <= n1 - n2; i++) {
            // Initialize the cost of changing the substring to be zero
            int costs = 0;
            // Compare each character of the substring to the corresponding character of b
            for (int k = 0; k < n2; k++) {
                if (a.charAt(i+k) != b.charAt(k)) {
                    costs += 1;
                }
            }
            // Initialize two pointers at the start and end of the substring
            int leftPtr = 0, rightPtr = n1 - 1;
            // Move the pointers towards the center, comparing characters along the way
            while (leftPtr < rightPtr) {
                // If the characters at the current pointers don't match and they are outside the substring,
                // there is no way to make the palindrome special, so we break out of the loop
                if (i <= leftPtr && leftPtr < i+n2 && i <= rightPtr && rightPtr < i+n2 && b.charAt(leftPtr-i) != b.charAt(rightPtr-i)) {
                    break;
                    }
                // If the characters at the current pointers are within the substring,
                // use the corresponding characters in b instead of a for the comparison
                char left = a.charAt(leftPtr);
                char right = a.charAt(rightPtr);
                if (i <= leftPtr && leftPtr < i+n2) {
                    left = b.charAt(leftPtr-i);
                    }
                if (i <= rightPtr && rightPtr < i+n2) {
                    right = b.charAt(rightPtr-i);
                }
                // If the characters at the current pointers don't match, increment the cost
                if (left != right) {
                    costs += 1;
                    }
                // Move the pointers closer to the center
                leftPtr += 1;
                rightPtr -= 1;
            }
            // If the pointers have crossed each other (i.e., the substring is a palindrome),
            // update the answer if the current cost is lower
            if (leftPtr >= rightPtr) {
                ans = Math.min(ans, costs);
            }
        }
        // If no special palindrome can be made, return -1, otherwise return the minimum cost
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}