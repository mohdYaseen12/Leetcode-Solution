class Solution {
    private long rangeSum(long[] pref, int l, int r){
        if(r < 0) return 0;
        if(l == 0) return pref[r];
        return pref[r] - pref[l-1];
    }
    
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] row0 = new long[n];
        long[] row1 = new long[n];
        long ans = Long.MAX_VALUE;
        
        row0[0] = grid[0][0];
        for(int i=1;i<n;i++){
            row0[i] = grid[0][i] + row0[i-1];
        }
        
        row1[0] = grid[1][0];
        for(int i=1;i<n;i++){
            row1[i] = grid[1][i] + row1[i-1];
        }
        
        for(int i=0;i<n;i++){
            long option1 = rangeSum(row0,i+1,n-1);
            long option2 = rangeSum(row1,0,i-1);
            long robot2choice = Math.max(option1,option2);
            ans = Math.min(ans,robot2choice);
            // System.out.println(ans);
        }
        return ans;
    }
}