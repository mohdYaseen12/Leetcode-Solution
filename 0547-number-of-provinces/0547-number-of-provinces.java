class Solution {
    // ************** DFS Solution ****************
    
//     public void dfs(List<List<Integer>> graph,int src,boolean[] visited){
//         visited[src] = true;
//        for(int nbr : graph.get(src)){
//            if(!visited[nbr]){
//                dfs(graph,nbr,visited);
//            }
//        }
        
//     }
//     public int findCircleNum(int[][] isConnected) {
//         int n = isConnected.length;
//         List<List<Integer>> graph = new ArrayList<>();
//         for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        
        
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(i == j) continue;
                
//                 if(isConnected[i][j] == 1) graph.get(i).add(j);
//             }
//         }
        
        
//         boolean[] visited = new boolean[n];
//         int count = 0;
//         for(int i=0;i<n;i++){
//             if(!visited[i]){
//                 count++;
//                 dfs(graph,i,visited);
//             }
//         }
//         return count;
        
//     }
    
    
    
    // ****************  BFS SOLUTION ***************
    public int findCircleNum(int[][] isConnected){
        
        int n = isConnected.length;
        int provinces = 0;
        
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                q.add(i);
                provinces++;
            }
            
            while(q.size() > 0){
                int curr = q.remove();
                visited[curr] = true;
                
                for(int j=0; j< n; j++){
                    if( j != curr && !visited[j] && isConnected[curr][j] == 1){
                        q.add(j);
                    }
                }
            }
        }
        return provinces;
    }
}