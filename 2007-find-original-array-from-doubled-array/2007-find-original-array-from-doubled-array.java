// ***************** APPROACH 2: Using Queue ****************
class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length == 1 || changed.length % 2 == 1) return new int[0];
        Queue<Integer> q = new LinkedList<>();
        
        Arrays.sort(changed);
        int[] original = new int[changed.length / 2];
        int idx = 0;
        
        for(int num : changed){
            if(!q.isEmpty() && q.peek() == num)
                original[idx++] = q.remove()/2;
            else q.add(num * 2);
        }
         return q.size() > 0 ? new int[0] : original;
    }
}


// ************** APPRAOCH 1: Using TreeMap **************
// class Solution {
//     public int[] findOriginalArray(int[] changed) {
//         if(changed.length == 1 || changed.length % 2 != 0) return new int[0];
        
//         TreeMap<Integer, Integer> map = new TreeMap<>();
        
//         for(int val : changed) map.put(val,map.getOrDefault(val,0)+1);
        
//         int[] original = new int[changed.length / 2];
//         int idx = 0;
        
//         for(int key : map.keySet()){
//             if(map.get(key) > map.getOrDefault(key + key, 0)) return new int[0];
            
//             for(int j=0;j<map.get(key);j++){
//                 original[idx++] = key;
                
//                 map.put(key+key,map.getOrDefault(key+key,0)-1);
//             }
//         }
//         return original;
//     }
// }

