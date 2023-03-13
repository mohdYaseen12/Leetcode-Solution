class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length == 1 || changed.length % 2 != 0) return new int[0];
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int val : changed) map.put(val,map.getOrDefault(val,0)+1);
        
        int[] original = new int[changed.length / 2];
        int idx = 0;
        
        for(int key : map.keySet()){
            if(map.get(key) > map.getOrDefault(key + key, 0)) return new int[0];
            
            for(int j=0;j<map.get(key);j++){
                original[idx++] = key;
                
                map.put(key+key,map.getOrDefault(key+key,0)-1);
            }
        }
        return original;
    }
}