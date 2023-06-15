class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU d = new DSU(edges.length);
        
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0]-1;
            int v = edges[i][1]-1;
            
            if(!d.union(u,v))
                return new int[]{u+1,v+1};
        }
        return new int[]{};
        
    }
}

public class DSU{
    int[] parent;
    int[] size;
    
    public DSU(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    public boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if( a == b) return false;
        if(a != b){
            if(size[a] < size[b]){
                int tmp = a;
                a = b;
                b = tmp;
            }
            parent[b] = a;
            size[a] += size[b];
        }
        return true;
        
    }
    
}