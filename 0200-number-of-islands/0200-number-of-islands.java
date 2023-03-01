class Solution {
    private void destroy(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        
        destroy(grid,i+1,j);
        destroy(grid,i-1,j);
        destroy(grid,i,j+1);
        destroy(grid,i,j-1);
        
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid.length == 0) return 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    destroy(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}