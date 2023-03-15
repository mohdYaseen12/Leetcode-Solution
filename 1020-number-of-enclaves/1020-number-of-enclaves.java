class Solution {
    private void destroy(int i, int j, int[][] grid){
        if(i<0 || i>grid.length-1 || j < 0 || j > grid[0].length-1 || grid[i][j] == 0 ) return;
        
        grid[i][j] = 0;
        destroy(i+1,j,grid);
        destroy(i-1,j,grid);
        destroy(i,j-1,grid);
        destroy(i,j+1,grid);
    }
    public int numEnclaves(int[][] grid) {
        
        int enclaves = 0;
        for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[0].length;j++){
               if(i == 0) destroy(i,j,grid);
               
               if(i == grid.length-1) destroy(i,j,grid);
           }
            
            destroy(i,0,grid);
            destroy(i,grid[0].length-1,grid);
        }
        
        for(int i = 0; i<grid.length;i++){
            for(int j=0;j<grid[0].length; j++){
                enclaves+=grid[i][j];
            }
        }
        return enclaves;
    }
}