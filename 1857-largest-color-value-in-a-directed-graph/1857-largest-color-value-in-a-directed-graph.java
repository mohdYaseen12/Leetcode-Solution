class Solution {
     public int largestPathValue(String colors, int[][] edges) {
        //use topological sort algorithm because x1<x2<x3< ... <xk
        //use jahn algo
        int n=colors.length();
        int[]indegree=new int[n];

        HashMap<Integer, ArrayList<Integer>>graph=new HashMap<>();
        for(int i=0;i<n;i++){
             graph.put(i,new ArrayList<Integer>());
        }
        for(int[]edge:edges){
            int u=edge[0];
            int v=edge[1];
            
            graph.get(u).add(v);
            indegree[v]++;

        }

        //now add all nodes initilayy with 0 inDEgree
           Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.add(i);
        }

         //run the BFS approach
         int visited=0;
         int[][]clr=new int[n][26];//fr each node max 26 colours
      
         while(q.size()>0){

             int parent=q.remove();
             int parClr=colors.charAt(parent)-'a';

             //remove-->do work-->add*-->viist

             //update the color
             clr[parent][parClr]+=1;

             for(int child:graph.get(parent)){
                 

                   // ***********misatke previously
                   /////////////update the each colour from parent array to child array 
                   //colour upto child yahan tak ka clolr updat ekiya h ***************///
                   for(int i=0;i<26;i++){
                       clr[child][i]=Math.max(clr[parent][i],clr[child][i]);
                   }
                //    clr[child][parClr]=Math.max(clr[child][parClr],clr[parent][parClr]);
                  // System.out.println("child is "+child+" an colour is "+clr[child][parClr]);
                     //make indegree--
                   indegree[child]--;
                   if(indegree[child]==0)q.add(child);
             }


             visited++;
         }

         // chek the cycle visited
         if(visited!=n)return -1;// there is cycle here

         //make ans
         int max=0;
         for(int i=0;i<clr.length;i++){
             for(int j=0;j<26;j++){
                 max=Math.max(max,clr[i][j]);
             }
         }
         return max;

        
    }
}