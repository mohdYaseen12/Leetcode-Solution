class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        
        int province = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
            
                q.add(i);
                province++;
            }
            
            while(q.size() > 0){
                int curr = q.remove();
                visited[curr] = true;
                for(int j=0;j<n;j++){
                    if(j != curr && !visited[j] && isConnected[curr][j]==1){
                        q.add(j);
                    }
                }
            }
        }
        return province;
    }
}