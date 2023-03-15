class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        
        int n = nums.length/2;
        
        for(int key : hm.keySet()){
            if(hm.get(key) > n) return key;
        }
        return -1;
    }
}