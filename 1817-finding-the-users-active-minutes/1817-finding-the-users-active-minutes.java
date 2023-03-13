class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        
        for(int[] log : logs){
            int id = log[0];
            int time = log[1];
            
            if(!map.containsKey(id)) map.put(id,new HashSet<>());
            map.get(id).add(time);
        }
        
        int[] res = new int[k];
        for(int key : map.keySet()){
            int uam = map.get(key).size(); // get required UAM -> size of the hashSet 
            
            res[uam-1]++; // update the result array
        }
        return res;
    }
}