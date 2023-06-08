class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        for(int[] mat : grid){
            // int count = 0;
            // boolean flag = false;
            for(int i=0;i<mat.length;i++){
                if(mat[i] < 0){
                    
                    ans += mat.length - i;
                    break;
                }
                // if(flag)
                    
            }
            
        }
        return ans;
    }
}