//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here // Code here
        Arrays.sort(Intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int prev[] = Intervals[0];
        // int prevEnd = Intervals[0][1];
        // int ans[][] = new int[Intervals.length][2];
        List<int[]> res = new ArrayList<>();
        for(int i=1;i<Intervals.length;i++){
            int curr[] = Intervals[i];
            // int currEnd = Intervals[i][1];
            
            // overlapping 
            if(curr[0] <= prev[1]) prev[1] = Math.max(curr[1], prev[1]);
            
            else{
                res.add(prev);
                prev = curr;
            }
        }
        res.add(prev);
        int[][] ans = new int[res.size()][2];
        int j=0;
        for(int[] i: res){
            ans[j++] = i;
        }
        return ans;
    }
}