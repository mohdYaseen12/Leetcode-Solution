class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,0});
        if(grid[0][0]+grid[r-1][c-1]>0)
            return -1;
        grid[0][0]=1;
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        while(q.size()>0)
        {
            int curr[]=q.remove();
            int a=curr[0];
            int b=curr[1];
            int cost=curr[2];
            if(a==r-1 && b==c-1)
                return cost+1;
            for(int i=0;i<8;i++)
            {
                int nx=a+dir[i][0];
                int ny=b+dir[i][1];
                if(nx<0 || nx>=r || ny<0 || ny>=c || grid[nx][ny]==1)
                    continue;
                grid[nx][ny]=1;
                q.add(new int[]{nx,ny,cost+1});
            }
            
        }
        
        return -1;
    }
}