class Solution {
    class Node{
        String dest;
        double value;
        Node(String dest, double value){
            this.dest = dest;
            this.value = value;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size();
        Map<String,List<Node>> graph = graph(equations,values);
        
        double[] res = new double[n];
        
        // evaluating queries.
        for(int i=0;i<n;i++){
            List<String> query = queries.get(i);
            String src = query.get(0); // getting srource from query
            String des = query.get(1); // getting destination from query
            
            // do dfs with new visited
            res[i] = dfs(graph,src,des,new HashSet<>());
        }
        return res;
        
    }
    
    private double dfs(Map<String, List<Node>> graph, String src, String dest, Set<String> visited){
        // base case
        if(!graph.containsKey(src) || !graph.containsKey(dest)) return -1.0;
        
        // we reachedd our destination i.e, source == destination
        if(src.equals(dest)) return 1.0;
        
        // mark visited
        visited.add(src);
        
        // check for neighbours
        for(Node nextNode : graph.get(src)){
            if(!visited.contains(nextNode.dest)){
                double val = nextNode.value;
                double ans = dfs(graph,nextNode.dest, dest,visited);
                // ans = 1.0 means we have reached destiation
                
                if(ans != -1.0){
                    return ans*val;
                }
            }
        }
        return -1.0;
        
    }
    
    
    // building graph
    private Map<String, List<Node>> graph(List<List<String>> equations, double[] values){
        Map<String, List<Node>> graph = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            List<String> list = equations.get(i);
            double val = values[i];
            String src = equations.get(i).get(0); // gettiing src from given eq
            String des = equations.get(i).get(1);
            
            graph.putIfAbsent(src,new ArrayList<>());
            graph.putIfAbsent(des,new ArrayList<>());
            
            graph.get(src).add(new Node(des,val));
            graph.get(des).add(new Node(src,1/val));
        }
        return graph;
    }
}