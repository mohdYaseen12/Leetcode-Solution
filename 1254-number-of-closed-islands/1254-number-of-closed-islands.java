class Solution {
    public int closedIsland(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int noOfClosedIsland=0;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]==0){
                    if(isIslandClosed(i,j,grid,visited)){
                        noOfClosedIsland+=1;
                    }
                }else{
                    visited[i][j]=true;
                }

            }
        }
        return noOfClosedIsland;
    }
     boolean isIslandClosed(int row,int col,int [][]grid , boolean [][]visited ){
        int n= grid.length;
        int m= grid[0].length;

        if(row>=n || col>=m || row<0 || col<0 ){
            return false;
        }
        if(grid[row][col]==1|| visited[row][col] )return true;
        visited[row][col]=true;
        int[] dirx={0,1,-1,0};
        int[] diry={1,0,0,-1};
        boolean isClosed=true;
        if(row==0||row==n-1||col==0||col==m-1){
            isClosed=false;
        }

        for(int i=0;i<4;i++){
            int x=dirx[i];
            int y=diry[i];
            //&& with isClosed is done at end otherwise due to shortcircuit property of and operator call to isIslandClosed() will not occur
            isClosed=isIslandClosed(row+x,col+y,grid,visited)&& isClosed;
        }
        return isClosed;
       
    }
}