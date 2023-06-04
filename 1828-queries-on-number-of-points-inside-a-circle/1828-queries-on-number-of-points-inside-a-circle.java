class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int idx = 0;
        
        for(int[] query : queries){
            int xc = query[0];
            int yc = query[1];
            int radius = query[2];
            int count = 0;
            
            for(int[] point : points){
                int x = point[0];
                int y = point[1];
                
                int dis = (xc-x) * (xc-x) + (yc-y) * (yc - y);
                
                if(dis <= radius * radius){
                    count++;
                }
            }
            ans[idx++] = count;
        }
        return ans;
    }
}