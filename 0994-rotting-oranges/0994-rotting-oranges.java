class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> rotten = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    rotten.add(new int[]{i,j});
                }
            }
        }
        if(fresh == 0)
            return 0;
        
        int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int time = 0;
        while(rotten.size() > 0){

            int len = rotten.size();
            for(int i=0;i<len;i++){

                int[] indices = rotten.remove();
                int r = indices[0];
                int c = indices[1];

                for(int j =0; j<4;j++){
                    int nr = r + direction[j][0];
                    int nc = c + direction[j][1];

                    if(nr >=0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1){
                        fresh--;
                        rotten.add(new int[]{nr,nc});
                        grid[nr][nc] = 2;
                    }
                }
            }
            time++;
        }
        if(fresh == 0) return time-1;
        return -1;

    }
}