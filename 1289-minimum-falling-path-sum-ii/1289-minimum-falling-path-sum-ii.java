class Solution {
    public int minFallingPathSum(int[][] grid) {
        int minSum = Integer.MAX_VALUE;
          int n = grid.length;
          if(n==1)return grid[0][0];

          for(int i=n-2;i>=0;i--){
              
              for(int j=0;j<n;j++){
                  int min = minNum(grid, j, i+1, n);
                  grid[i][j] +=min;
              }
          }
          for(int i=0;i<n;i++){
              minSum =Math.min(minSum, grid[0][i]);
          }
          
          return minSum;
    }
    
    
      // finding the smallest element in (i+1)th row 
      public int minNum(int[][] grid, int index, int row, int n){
          int min = Integer.MAX_VALUE;
          for(int i=0;i<n;i++){
              if(i!=index){
                  min = Math.min(min,grid[row][i]);
              }
          }
          return min;
      }
}